package com.finuniversally.service.impl;

import com.finuniversally.cache.DataCache;
import com.finuniversally.model.*;
import com.finuniversally.service.IJudgementStrategyService;
import com.finuniversally.untils.CustomerGenerateUtils;
import com.finuniversally.vo.CustomerDataVO;
import com.finuniversally.vo.OrderDealData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 策略的判断
 * Created by may on 2018/4/23.
 */
@Service
@Transactional
public class JudgementStrategyServiceImpl implements IJudgementStrategyService {

    //通过策略表的key值找到对应策略表的客户数据
    private Map<String, List<CustomerDataVO>> customerDataVOs = CustomerGenerateUtils.getCustomerDataVOs();
    //存储TCP数据
    private List<DealData> dealDatas = new ArrayList<>();
    //策略表的key值,存储跟单明细 todo 要删的，到时候通过sql查出来
    private Map<String, List<DocumentaryDetailedData>> detailedDatas =  CustomerGenerateUtils.getDetailedDatas();

    //发送MQ
    @Autowired
    private com.finuniversally.service.ITradeMsgService ITradeMsgService;

    @Override
    public List<Strategy> findStrategy(DealData data, List<Customer> customerList) {
        //装符合用户的策略
         List<Strategy> strategies = new ArrayList<>();
        //添加TCP数据
        dealDatas.add(data);
        for (Customer c : customerList) {
            if (c.getLogin().equals(data.getLogin())) {
                for (Strategy strategy : c.getStrategies()) {
                    //TODO 获取该用户下的所有策略,通过品种找策略
                    if (strategy.getVariety().getVarietyCode().equals(data.getVarietyCode())) {
                        if (strategies.size() != 0) {
                            for (Strategy strategy1 : strategies) {
                                if (!strategy.getId().equals(strategy1.getId())) {
                                    strategies.add(strategy);
                                }
                            }
                        } else {
                            strategies.add(strategy);
                        }
                    }

                }

            }
        }
        return strategies;
    }

    @Override
    public OrderDealData getOrderDealData(DealData data) {
        //查找策略
        List<Strategy> strategys = this.findStrategy(data, DataCache.getInstance().getCustomerList());

        //传送给交易系统的交易对象
        OrderDealData orderDealData = new OrderDealData();
        if (strategys.size() > 0) {
            for (Strategy strategy : strategys) {
                Account account = checkLogin(strategy, data.getLogin());
                //判断该用户是否登录
                if (account != null) {
                    //发mq去登录
                    ITradeMsgService.login(account);
                }
                //Map的key值
                StringBuilder sBuilder = new StringBuilder(100);
                sBuilder.append(strategy.getAccount().getUsername()).append(strategy.getVariety().getVarietyCode()).
                        append(strategy.getCustomerPlatform().getName());

                //每回一个客户数据过来，都创建一个跟单明细
                DocumentaryDetailedData detailedData = new DocumentaryDetailedData();
                detailedData.setLogin(data.getLogin());
                detailedData.setOpenOrderNum(data.getOpenOrderNum());
                detailedData.setCmd(data.getCmd());
                detailedData.setStrategy(strategy);



                List<DocumentaryDetailedData> documentaryDetailedDatas ;
                if(detailedDatas.get(sBuilder.toString())!=null){
                    //如果该策略已经存在了明细对象那么就不用重新创建
                    documentaryDetailedDatas = detailedDatas.get(sBuilder.toString());
                }else {
                    //如果不存在就重新创建
                    documentaryDetailedDatas =new ArrayList<>();
                }
                //假数据的跟单数据明细 TODO 要删的
                if (documentaryDetailedDatas.size()==0){

                    documentaryDetailedDatas.add(CustomerGenerateUtils.getDetailedData(strategy));
                }
                detailedDatas.put(sBuilder.toString(), documentaryDetailedDatas);


                //装客户数据的，如果已经有了，就用原来的，如果没有就用新的
                List<CustomerDataVO> customerDataVOList;
                if (customerDataVOs.get(sBuilder.toString()) != null) {
                    customerDataVOList = customerDataVOs.get(sBuilder.toString());
                } else {
                    customerDataVOList = new ArrayList<>();
                }
                //添加客户的数据
                customerDataVOList.add(this.setCustomerDataVO(data,strategy));

                //添加那个策略关联哪个客户数据
                customerDataVOs.put(sBuilder.toString(), customerDataVOList);

                //跟单参数的判断
                DocumentaryParameters documentaryParameters = strategy.getDocumentaryParameters();
                if (documentaryParameters != null) {

                    //交易账号
                    orderDealData.setDealAccount("EF-" + strategy.getAccount().getUsername());
                    //交易手数
                    orderDealData.setOpenNum(data.getOpenOrderNum() + data.getNewOpenOrderNum());
                    //开平
                    orderDealData.setOpenClose(data.getOpenClose());
                    //开仓单号
                    orderDealData.setOpenNum(data.getOpenOrderNum());
                    //时间
                   // orderDealData.setOpenTime(new SimpleDateFormat(""));
                    SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss");
                    orderDealData.setCreateTime(formatter.format(data.getCreateTime()));

                    //查找对应客户的跟单参数 todo 封装成一个跟单参数类
                    List<CustomerDocumentaryParameters> cusDocumentaryParameters = this.findCusDocumentaryParameters(data);

                    //平台参数和客户参数的判断
                    for (CustomerDocumentaryParameters parameter : cusDocumentaryParameters) {
                        if (parameter.getId().equals(strategy.getId())) {
                            //设置多空
                            orderDealData.setCmd(data.getCmd());
                            //正向
                            if (parameter.getType()) {
                                //正向买入
                                if (data.getCmd().equals(DealData.CMD_BUY)) {
                                    //设置手数
                                    orderDealData = this.checkBuyHandNum(data, parameter, orderDealData,detailedData);
                                    //设置市价和限价
                                    orderDealData = this.checkPoint(documentaryParameters, orderDealData);

                                } else {
                                    //正向卖出
                                    orderDealData = this.positiveSale(parameter,sBuilder.toString(),data,orderDealData
                                            ,documentaryParameters,detailedData);
                                }

                            } else {
                                //反向 TODO
                                orderDealData.setCmd(data.getCmd());
                            }
                        }
                        //todo 单笔最大止盈,单笔最大止损，账户止损 实现自动平仓
                    }

                }
                //添加客户明细
                documentaryDetailedDatas.add(detailedData);
                detailedDatas.put(sBuilder.toString(), documentaryDetailedDatas);

                //TODO 修改内存中策略的状态 到时候通过数据库获取 要删除的，到时候应该是直接通过数据库去update
                List<Strategy> allStrategies = CustomerGenerateUtils.getAllStrategies();
                for (Strategy allStrategy : allStrategies) {
                    if (strategy.getId().equals(allStrategy.getId())) {
                        if (strategy.getStatus().equals(Strategy.STRATEGY_STATUS_YES)) {
                            break;
                        } else {
                            allStrategy.setStatus(Strategy.STRATEGY_STATUS_YES);
                        }
                    }
                }


            }
        }
        return orderDealData;
    }

    @Override
    public List<CustomerDocumentaryParameters> findCusDocumentaryParameters(DealData data) {
        //假客户数据
        List<Customer> customers = DataCache.getInstance().getCustomerList();

        for (Customer customer : customers) {
            if (customer.getLogin().equals(data.getLogin())) {
                return customer.getCustomerDocumentaryParameters();
            }
        }
        return null;
    }

    @Override
    public List<CustomerDataVO> getCustomerDataVOByKey(String key) {
        return customerDataVOs.get(key);
    }

    @Override
    public List<DocumentaryDetailedData> getDocumentaryDetailedDataByKey(String key) {
        return detailedDatas.get(key);
    }

    @Override
    public Account checkLogin(Strategy strategy, String customerName) {
        Account account = null;
        //假客户数据
        List<Customer> customers = DataCache.getInstance().getCustomerList();
        Customer customer = null;
        //通过账号名找到对应账号的实体
        for (Customer c : customers) {
            if (customerName.equals(c.getLogin())) {
                customer = c;
            }
        }
        //先获取账号
        for (Strategy str : customer.getStrategies()) {
            if (str.getAccount().getId().equals(strategy.getAccount().getId())) {
                account = str.getAccount();
            }
        }
        //再查找该账号下的所有策略 todo 用SQL查
        List<Strategy> strategyList = new ArrayList<>();
        List<Strategy> allStrategies = CustomerGenerateUtils.getAllStrategies();
        for (Strategy allStrategy : allStrategies) {
            if (account.getId() == allStrategy.getAccount().getId()) {
                strategyList.add(allStrategy);
            }
        }
        //再去遍历账号的策略有没有已经启动的，如果有已经启动的就不登录
        for (Strategy accountStrategy : strategyList) {
            if (accountStrategy.getStatus().equals(Strategy.STRATEGY_STATUS_YES)) {
                return null;
            }
        }

        return account;
    }

    /**
     * 买入判断手数
     *
     * @param
     * @Author: May
     * @Date: 18:20 2018/4/25
     */
    private OrderDealData checkBuyHandNum(DealData data, CustomerDocumentaryParameters parameter, OrderDealData orderDealData,
                                          DocumentaryDetailedData detailedData) {
        //买入
        //按比例买
        if (parameter.getHandType().equals(CustomerDocumentaryParameters.HANDTYPE_YES)) {
            //设置手数
            orderDealData.setHandNum(data.getCounts() * parameter.getRatioHandNum());
            //设置跟单明细的手数,要等交易系统传过来
            detailedData.setLeftoverCounts(data.getCounts() * parameter.getRatioHandNum());
        } else {
            //固定手数
            detailedData.setCounts(parameter.getHandNum());
            //设置跟单明细的手数
            detailedData.setLeftoverCounts(parameter.getHandNum());
            orderDealData.setHandNum(parameter.getHandNum());
        }
        return orderDealData;
    }

    /**
     * 判断是市价还是限价，确定点位
     * @param
     * @Author: May
     * @Date: 18:19 2018/4/25
     */
    private OrderDealData checkPoint(DocumentaryParameters documentaryParameters, OrderDealData orderDealData) {
        //设置市价or限价
        orderDealData.setOrderPoint(documentaryParameters.getOrderPoint());
        //判断下单点位是否比客户好
        if(documentaryParameters.getCustomerPoint()!=null){

            if (documentaryParameters.getCustomerPoint()) {
                //下单点位比客户好
                orderDealData.setCustomerPointNum(documentaryParameters.getCustomerPointNum());
            } else {
                //比客户差
                Double num = -documentaryParameters.getCustomerPointNum();
                System.out.println(num);
                orderDealData.setCustomerPointNum(documentaryParameters.getCustomerPointNum());
            }
        }

        return orderDealData;
    }
    /**
     * 判断卖出的手数
     *@Author: May
     *@param orderDealData
     *@Date: 18:59 2018/4/25
     */
    private OrderDealData checkSaleHandNum(OrderDealData orderDealData, Double noClose, Double orderDealDataHandNum,
                                           DocumentaryDetailedData detailedData){
        //设置手数
        if (noClose >= orderDealDataHandNum) {
            orderDealData.setHandNum(orderDealDataHandNum);
            //剩余的手数是没有剩余的手数
            detailedData.setCounts(orderDealDataHandNum);


        } else if (noClose != 0) {
            orderDealData.setHandNum(noClose);
            detailedData.setCounts(noClose);
        }else{
            detailedData.setStatus(DocumentaryDetailedData.DETAILED_STATUS_NO);
            //如果手数为 O，不用下单
            return null;
        }
        return orderDealData;
    }
    
    /**
     * 设置客户数据
     *@Author: May
     *@param
     *@Date: 19:08 2018/4/25
     */
    private CustomerDataVO setCustomerDataVO(DealData data, Strategy strategy){
        CustomerDataVO customerDataVO = new CustomerDataVO();

        customerDataVO.setLogin(data.getLogin());
        customerDataVO.setOpenOrderNum(data.getOpenOrderNum());
        customerDataVO.setVarietyCode(data.getVarietyCode());
        customerDataVO.setCmd(data.getCmd());
        customerDataVO.setHandNum(data.getCounts());
        customerDataVO.setOpenPrice(data.getPrice());
        customerDataVO.setOpenTime(data.getCreateTime());
        customerDataVO.setCustomerSurplus(data.getProfit());
        customerDataVO.setStatus(CustomerDataVO.STATUS_NO);
        customerDataVO.setId(1L);
        customerDataVO.setStrategy(strategy);
        return customerDataVO;
    }


    /**
     * 累加该用户的开仓数
     *@Author: May
     *@param
     *@Date: 19:23 2018/4/25
     */
    private Double addHandNum(String key, DealData data, Double noClose){
        //找到对应的客户的跟单明细，如果有数据库就可以通过SQL，参数是客户的名字，策略的ID，
        // 查找到还没有平仓的集合，再通过时间的顺序进行排序
        List<DocumentaryDetailedData> detailedDataList = detailedDatas.get(key);
        for (DocumentaryDetailedData detailedData : detailedDataList) {
            //通过客户名字找到对应的明细
            if (detailedData.getLogin().equals(data.getLogin())) {
                //去找还没有平仓的明细
                if (detailedData.getCloseTime() == null && detailedData.getLeftoverCounts() != null) {
                    //把剩余的手数累加
                    noClose += detailedData.getLeftoverCounts();

                }
            }
        }
        return noClose;
    }
    /**
     * 正向卖出
     *@Author: May
     *@param
     *@Date: 19:22 2018/4/25
     */
    private OrderDealData positiveSale(CustomerDocumentaryParameters parameter, String key, DealData data
            , OrderDealData orderDealData, DocumentaryParameters documentaryParameters, DocumentaryDetailedData detailedData){
        //一共卖多少手，如果不够就不可以卖了，应该是先算出库存是否足够，
        Double orderDealDataHandNum;
        //计算库存手数
        Double noClose = 0D;
        //按比例
        if (parameter.getHandType().equals(CustomerDocumentaryParameters.HANDTYPE_YES)) {

            orderDealDataHandNum = data.getCounts() * parameter.getRatioHandNum();
            noClose =addHandNum(key,data,noClose);
            //设置市价和限价
            orderDealData = this.checkPoint(documentaryParameters, orderDealData);
            //判断卖出的手数,如果库存没有就会返回个空
            orderDealData = this.checkSaleHandNum(orderDealData, noClose, orderDealDataHandNum,detailedData);
        }else{
            //固定手数
            orderDealDataHandNum = data.getCounts();
            noClose =addHandNum(key,data,noClose);
            //设置市价和限价
            orderDealData = this.checkPoint(documentaryParameters, orderDealData);
            //判断卖出的手数,如果库存没有就会返回个空
            orderDealData = this.checkSaleHandNum(orderDealData, noClose, orderDealDataHandNum,detailedData);
        }
        return orderDealData;
    }
}
