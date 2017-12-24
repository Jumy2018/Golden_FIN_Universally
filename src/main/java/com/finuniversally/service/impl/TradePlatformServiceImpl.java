package com.finuniversally.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.dao.TradePlatformDao;
import com.finuniversally.model.TradePlatform;
import com.finuniversally.service.TradePlatformService;
import com.finuniversally.untils.TransFormDataSource;



@Component
public class TradePlatformServiceImpl implements TradePlatformService{
	@Autowired
	private TradePlatformDao tradePlatformDao;
	
	
	@Override
	public List<TradePlatform> getAllPlatform() {
		return tradePlatformDao.getAllPlatform();
	}

}
