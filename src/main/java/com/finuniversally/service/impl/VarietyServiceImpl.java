package com.finuniversally.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.mapper.VarietyMapper;
import com.finuniversally.model.Variety;
import com.finuniversally.service.VarietyService;
import com.finuniversally.untils.TransFormDataSource;

@Component
public class VarietyServiceImpl implements VarietyService{
	@Autowired
	private VarietyMapper varietyMapper;
	
	@Override
	public List<Variety> getVarietys() {
		return varietyMapper.getVarietys();
	}

	@Override
	public Variety getVarietyByName(String name) {
		return varietyMapper.getVarietyByName(name);
	}
}
