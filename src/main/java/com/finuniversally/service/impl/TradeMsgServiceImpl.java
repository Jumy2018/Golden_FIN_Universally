package com.finuniversally.service.impl;

import com.alibaba.fastjson.JSON;
import com.finuniversally.model.Account;
import com.finuniversally.service.IProducerService;
import com.finuniversally.service.ITradeMsgService;
import com.finuniversally.vo.OrderDealData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;

/**
 * Created by may on 2018/4/25.
 */

@Service@Transactional
public class TradeMsgServiceImpl implements ITradeMsgService {

    @Autowired
    private IProducerService IProducerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Override
    public void login(Account account) {
        IProducerService.sendMessage(destination, JSON.toJSONString(account));
    }

    @Override
    public void loginOut(Account account) {
        IProducerService.sendMessage(destination, JSON.toJSONString(account));
    }

    @Override
    public void addOrder(OrderDealData orderDealData) {
        IProducerService.sendMessage(destination, JSON.toJSONString(orderDealData));

    }

    @Override
    public void cancelOrder() {

    }
}
