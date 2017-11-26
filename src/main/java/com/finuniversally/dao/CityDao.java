package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.finuniversally.model.City;


@Component
public interface CityDao {
	@Select("select * from City where id = #{cityId}")
	public City getCityById(int cityId);
}
