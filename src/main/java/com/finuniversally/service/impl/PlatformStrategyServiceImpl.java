package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.mapper.PlatformStrategyMapper;
import com.finuniversally.model.PlatformStrategy;
import com.finuniversally.service.OrderService;
import com.finuniversally.service.PlatformStrategyService;


@Component
public class PlatformStrategyServiceImpl implements PlatformStrategyService {

	@Autowired
	private PlatformStrategyMapper platformStrategyMapper;
	
	@Autowired
	private OrderService orderService;

	@Override
	public void add(PlatformStrategy platformStrategy) {
		/**
		 * 获取该平台的实时净头寸
		 */
		platformStrategy.setBaseNetPosition(orderService.getNetPosition(platformStrategy.getPlatform().getName(),platformStrategy.getVariety().getVarietyCode()));
		platformStrategyMapper.savePlatformStrategy(platformStrategy);
	}
}
