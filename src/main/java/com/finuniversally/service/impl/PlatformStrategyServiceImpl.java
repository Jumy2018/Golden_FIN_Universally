package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.mapper.PlatformStrategyMapper;
import com.finuniversally.model.PlatformStrategy;
import com.finuniversally.service.PlatformStrategyService;


@Component
public class PlatformStrategyServiceImpl implements PlatformStrategyService {

	@Autowired
	private PlatformStrategyMapper platformStrategyMapper;
	
	@Override
	public void add(PlatformStrategy platformStrategy) {
		/**
		 * 获取该平台的实时净头寸
		 */
		
//		platformStrategy.setBaseNetPosition();
		platformStrategyMapper.add(platformStrategy);
	}

}
