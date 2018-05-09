package com.finuniversally.service;

import com.finuniversally.model.*;
import com.finuniversally.vo.CustomerDataVO;
import com.finuniversally.vo.OrderDealData;

import java.util.List;

/**
 * Created by may on 2018/4/23.
 * 策略业务逻辑
 *
 * @author may
 */

public interface IJudgementStrategyService {
    /*
     *寻找对应的策略
     *@Author: May
     *@param data
     * @param customerList
     *@Date: 14:22 2018/4/23
     */
    public List<Strategy> findStrategy(DealData data, List<Customer> customerList);

    /**
     * 返回下单所需的条件
     *@Author: May
     *@param data
     *@Date: 14:24 2018/4/23
     */
    public OrderDealData getOrderDealData(DealData data);
    /**
     * 返回用户下符合条件的跟单参数
     *@Author: May
     *@param
     *@Date: 16:14 2018/4/23
     */
    public List<CustomerDocumentaryParameters> findCusDocumentaryParameters(DealData data);

    /**
     * 通过对应的策略的Key值找到对应策略的客户数据
     *@Author: May
     *@param key：交易账号的名字+品种的英文名字+数据源平台名称xiaoXAUUSD.eDZ
     *@Date: 18:28 2018/4/24
     */
    public List<CustomerDataVO> getCustomerDataVOByKey(String key);
    /**
     * 通过对应的策略的Key值找到对应策略的跟单数据明细
     *@Author: May
     *@param
     *@Date: 18:39 2018/4/24
     */
    public List<DocumentaryDetailedData> getDocumentaryDetailedDataByKey(String key);
    /**
     * 判断交易账号是否已经登录了
     *@Author: May
     *@param
     *@Date: 11:13 2018/4/25
     */
    public Account checkLogin(Strategy strategy, String customerName);


}
