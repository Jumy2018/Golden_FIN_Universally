package com.finuniversally.service;

import java.util.List;

import com.finuniversally.model.TradePlatform;

/**
 * 交易平台相关业务
 * @author riseSun
 *
 * 2017年12月24日上午10:50:47
 */
public interface TradePlatformService {
	/**
	 * 获取所有交易平台
	 * @return
	 * @author riseSun
	
	 * 2017年12月24日上午10:51:52
	 */
	public List<TradePlatform> getAllPlatform();
}
