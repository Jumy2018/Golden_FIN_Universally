package com.finuniversally.service.impl;

import com.finuniversally.model.*;
import com.finuniversally.service.ICheckStrategyService;
import com.finuniversally.service.ITradeMsgService;
import com.finuniversally.untils.CustomerGenerateUtils;
import com.finuniversally.vo.CustomerDataVO;
import com.finuniversally.vo.OrderDealData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 净头寸的判断
 * Created by may on 2018/5/8.
 */
@Service
@SuppressWarnings("All")
public class CheckStrategyServiceImpl implements ICheckStrategyService {
    //死策略
    private Strategy strategy = CustomerGenerateUtils.getStrategy();
    //该策略的客户数据
    private List<CustomerDataVO> customerDataVOs = new ArrayList<>();
    //该策略的明细数据
    private List<DocumentaryDetailedData>  documentaryDetailedDatas = new ArrayList<>();
    private Long id=1L;//跟单明细的id
    //发送MQ
    private ITradeMsgService tradeMsgService;
    @Override
    public Strategy getStrategy() {


        return strategy;
    }

    @Override
    public OrderDealData getOrderDealData(DealData data) {
        //判断是否登录了
        if(strategy.getStatus().equals(Strategy.STRATEGY_STATUS_NO)){
            Account account = strategy.getAccount();
            //发送MQ去登录
            tradeMsgService.login(account);
            //设计启动
            strategy.setStatus(Strategy.STRATEGY_STATUS_YES);
        }
        //创建交易对象
        OrderDealData orderDealData = new OrderDealData();
        //设置交易对象的交易账号
        orderDealData.setDealAccount(strategy.getAccount().getUsername());
        //判断策略的跟单参数
        DocumentaryParameters documentaryParameters = strategy.getDocumentaryParameters();
        //净头寸
        Double headNum = documentaryParameters.getHeadNum();
        //获取原有的持仓数
        Integer holdNum = documentaryParameters.getHoldNum();
        if(documentaryParameters.getType().equals(DocumentaryParameters.STRATEGY_TYPE_NO)){
            //反向跟单
            //判断数据的多空方向
            if(data.getCmd().equals(DealData.CMD_BUY)){
                //多，当净头寸的值为正的时候，持仓数应该为负
                headNum += data.getCmd();
                //应持仓多少手
                int sum = (int) (headNum/10);
                //当数值不等于0的时候才可以进行跟单操作
                if(sum !=0){
                    //下单为空单
                    if(headNum > 0){
                        //应有的持仓数为负
                        sum = -sum;
                        //如果大于原有的持仓数就是要平仓,并且不为正数就不需要开仓
                        if(sum>holdNum&&sum<=0){
                            //创建跟单明细
                            DocumentaryDetailedData detailedData = new DocumentaryDetailedData();
                            detailedData.setId(id++);
                            //本次应该下单的数量
                            int interim = sum - holdNum;
                            //设置交易对象下单手数
                            orderDealData.setHandNum((double) Math.abs(interim));
                            //设置多空
                            orderDealData.setCmd(DealData.CMD_SELL);
                            //平仓
                            orderDealData.setOpenClose(DealData.OPENCLOSE_CLOSE);
                            //设置时间
                            SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss");
                            orderDealData.setCreateTime(formatter.format(data.getCreateTime()));
                            //设置交易对象的点位
                            checkPoint(documentaryParameters,orderDealData);

                            //设置跟单明细的手数
                            detailedData.setCounts((double) Math.abs(interim));
                            //设置跟单明细的多空类型
                            detailedData.setCmd(DealData.CMD_SELL);
                            //往该策略添加明细
                            documentaryDetailedDatas.add(detailedData);
                            //发送交易请求
                            tradeMsgService.addOrder(orderDealData);
                        }
                    }else{
                        //下单为多单
                        //净头寸如果为负数，应有的持仓数为正
                        sum = -sum;
                       //如果大于原有的持仓数就是要平仓,而且为正数就需要开仓
                        if(sum>holdNum&&sum>0){
                            //把
                        }
                    }

                }

            }else{
                //空的
            }
        }else{
            //正向跟单
        }
        return null;
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


}
