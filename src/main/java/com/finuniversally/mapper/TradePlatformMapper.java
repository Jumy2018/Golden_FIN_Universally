package com.finuniversally.mapper;

import java.util.List;

import com.finuniversally.model.TradePlatform;

public interface TradePlatformMapper {
	/**
	 * 根据ID获取交易平台
	 * @param id
	 * @return
	 * @author riseSun
	
	 * 2017年12月26日上午12:31:11
	 */
	public TradePlatform getTradePlatformById(Long id);
	/**
	 * 获取所有的交易平台
	 * @return
	 * @author riseSun
	
	 * 2017年12月26日上午12:50:36
	 */
	public List<TradePlatform> getAllPlatform();
}
