package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.dao.CityDao;
import com.finuniversally.model.City;
import com.finuniversally.service.CityService;


@Component
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public City getCityById(int cityId) {
		return cityDao.getCityById(cityId);
	}

}
