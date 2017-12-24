package com.finuniversally.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.finuniversally.model.TradePlatform;

public interface TradePlatformDao {
	@Select("select ID,PLATFORM_NAME as name from GFU_TRADE_PLATFORM")
	public List<TradePlatform> getAllPlatform();
}
