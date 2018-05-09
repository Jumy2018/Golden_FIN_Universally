package com.finuniversally.service;

import com.finuniversally.model.DealData;
import com.finuniversally.model.Strategy;
import com.finuniversally.vo.OrderDealData;

/**
 * 净头寸的变化
 * Created by may on 2018/5/8.
 */
public interface ICheckStrategyService {
    /** 返回策略
     *@Author: May
     *@param
     *@Date: 12:48 2018/5/8
     */
     Strategy getStrategy();

    /**
     * 返回下单所需的条件
     *@Author: May
     *@param data
     *@Date: 14:24 2018/4/23
     */
    public OrderDealData getOrderDealData(DealData data);
}
