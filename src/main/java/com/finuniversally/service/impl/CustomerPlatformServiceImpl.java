package com.finuniversally.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.mapper.CustomerPlatformMapper;
import com.finuniversally.mapper.TradePlatformMapper;
import com.finuniversally.model.CustomerPlatform;
import com.finuniversally.service.CustomerPlatformService;

@Component
public class CustomerPlatformServiceImpl implements CustomerPlatformService {

	@Autowired
	private CustomerPlatformMapper customerPlatformMapper;

	@Override
	public List<CustomerPlatform> getAllPlatform() {
		return customerPlatformMapper.getAllPlatform();
	}

}
