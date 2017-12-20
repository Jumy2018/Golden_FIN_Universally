package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.dao.OrderDao;
import com.finuniversally.service.OrderService;

@Component
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Override
	public Double getHoldQtys(Long cmd) {
		return orderDao.getHoldQtys(cmd);
	}
}
