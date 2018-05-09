package com.finuniversally.untils;

import com.finuniversally.model.*;
import com.finuniversally.vo.CustomerDataVO;

import java.math.BigDecimal;
import java.util.*;


/*
*
* 初始化客户和策略
* */
public abstract class CustomerGenerateUtils {
    //返回所有总策略，现在没有用处了
    private static List<Strategy> allStrategies = new ArrayList<>();
    //返回策略的客户数据，现在没有用处了
    private static Map<String, List<CustomerDataVO>> customerDataVOs = new HashMap<>();
    //返回策略的跟单数据，现在没有用处了
    private static Map<String, List<DocumentaryDetailedData>> detailedDatas = new HashMap<>();

    /**
     * 客户的跟单数据，品种，策略，账号的死数据
     *@Author: May
     *@param
     *@Date: 17:18 2018/4/24
     */
    public static Customer GenerateCustomer(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setLogin("1082050");
        //客户的跟单参数
        List<CustomerDocumentaryParameters> parameters = new ArrayList<>();
        List<Strategy> strategies = new ArrayList<>();
        Strategy strategy = new Strategy();
        strategy.setId(1L);
        CustomerPlatform customerPlatform = new CustomerPlatform(1L,"DZ");
        strategy.setCustomerPlatform(customerPlatform);
        TradePlatform tradePlatform = new TradePlatform(1L,"EF");
        //设计交易账号
        Account account = new Account(1L,"xiao","123",tradePlatform);
        strategy.setAccount(account);
        //设计品种
        Variety variety=new Variety(1L,"黄金","XAUUSD.e");
        strategy.setVariety(variety);
        //设计状态
        strategy.setStatus(Strategy.STRATEGY_STATUS_NO);
        //设计平台的跟单参数
/*
        DocumentaryParameters documentaryParameters = new DocumentaryParameters(1L,1,null,null,0,0,0);
*/
        DocumentaryParameters documentaryParameters = new DocumentaryParameters(1L,DocumentaryParameters.
                STRATEGY_TYPE_NO,10,1,1,null,null,0,0,0,0.0,0);
        strategy.setDocumentaryParameters(documentaryParameters);
        //用于strategy
        List<Customer> customers = new ArrayList<>();
        //客户的跟单参数 todo 净头寸没用的
        CustomerDocumentaryParameters customerDocumentaryParameters=new CustomerDocumentaryParameters();
        customerDocumentaryParameters.setId(1L);
        customerDocumentaryParameters.setHandNum(1D);
        customerDocumentaryParameters.setType(true);
        customerDocumentaryParameters.setHandType(CustomerDocumentaryParameters.HANDTYPE_YES);
        customerDocumentaryParameters.setRatioHandNum(2D);
        customerDocumentaryParameters.setStrategy(strategy);
        parameters.add(customerDocumentaryParameters);
        customer.setCustomerDocumentaryParameters(parameters);
        customers.add(customer);
        //策略是默认跟所有客户
        strategy.setCustomers(customers);
        strategies.add(strategy);
        customer.setStrategies(strategies);


        if(allStrategies.size()==0){
            allStrategies.add(strategy);
        }else{

            for (Strategy allStrategy : allStrategies) {
                if(strategy.getId().equals(allStrategy.getId())){
                    break;
                }else{
                    allStrategies.add(strategy);
                }
            }
        }

        return customer;

    }
    /**
     * 已成功交易的数据
     *@Author: May
     *@param
     *@Date: 17:19 2018/4/24
     */
    public static DocumentaryDetailedData getDetailedData(Strategy strategy){
        DocumentaryDetailedData detailedData = new DocumentaryDetailedData();
        detailedData.setId(1L);
        detailedData.setLogin("1082050");
        detailedData.setOpenOrderNum("175616812");
        detailedData.setTradeNum("2323232323");
        detailedData.setCmd(DealData.CMD_BUY);
        detailedData.setCounts(0.5D);
        detailedData.setOpenPrice(1334.5D);
        detailedData.setOpenTime(new Date());
        detailedData.setPoundage(new BigDecimal("955"));
        detailedData.setStatus(DocumentaryDetailedData.DETAILED_STATUS_YES);
        detailedData.setStrategy(strategy);
        detailedData.setLeftoverCounts(0.5D);
        detailedData.setAlreadyProfit(new BigDecimal("221"));


        return detailedData;
    }
    /**
     * 初始化策略，唯一有用的是这个
     *@Author: May
     *@param
     *@Date: 10:21 2018/5/9
     */
    public static Strategy getStrategy(){
        Strategy strategy =new Strategy();
        strategy.setId(1L);
        CustomerPlatform customerPlatform = new CustomerPlatform(1L,"DZ");
        strategy.setCustomerPlatform(customerPlatform);
        TradePlatform tradePlatform = new TradePlatform(1L,"EF");
        //设计交易账号
        Account account = new Account(1L,"xiao","123",tradePlatform);
        strategy.setAccount(account);
        //设计品种
        Variety variety=new Variety(1L,"黄金","XAUUSD.e");
        strategy.setVariety(variety);
        //设计状态
        strategy.setStatus(Strategy.STRATEGY_STATUS_NO);
        //设计平台的跟单参数,反向跟单,净头寸每变化10手跟1手
        DocumentaryParameters documentaryParameters = new DocumentaryParameters(1L,DocumentaryParameters.
                STRATEGY_TYPE_NO,10,1,1,null,null,0,0,0,0.0,0);
        strategy.setDocumentaryParameters(documentaryParameters);

        return strategy;
    }

    public static List<Strategy> getAllStrategies (){
        //return allStrategies;
        return allStrategies;
    }
    public static Map<String, List<CustomerDataVO>> getCustomerDataVOs (){
        //return allStrategies;
        return customerDataVOs;
    }
    public static Map<String, List<DocumentaryDetailedData>> getDetailedDatas (){
        //return allStrategies;
        return detailedDatas;
    }


}
