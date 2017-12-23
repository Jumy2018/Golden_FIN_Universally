package com.finuniversally.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.dao.VarietyDao;
import com.finuniversally.model.Variety;
import com.finuniversally.service.VarietyService;
import com.finuniversally.untils.MultipleDataSource;

@Component
public class VarietyServiceImpl implements VarietyService{
	@Autowired
	private VarietyDao varietyDao;
	
	@Override
	@Transactional
	public List<Variety> getVarietys() {
		MultipleDataSource.setDataSourceKey("dataSourceLocal");
		return varietyDao.getVarietys();
//		MultipleDataSource.removeDataSourceKey();
	}

	@Override
	@Transactional
	public Variety getVarietyByName(String name) {
		MultipleDataSource.setDataSourceKey("dataSourceLocal");
		return varietyDao.getVarietyByName(name);
//		MultipleDataSource.removeDataSourceKey();
	}
}
