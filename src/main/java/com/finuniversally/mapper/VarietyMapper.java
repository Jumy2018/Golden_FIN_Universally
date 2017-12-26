package com.finuniversally.mapper;

import java.util.List;

import com.finuniversally.model.Variety;

public interface VarietyMapper {
	/**
	 * 获取所有的品种
	 * @return
	 * @author riseSun
	
	 * 2017年12月26日上午12:52:06
	 */
	public List<Variety> getVarietys();
	/**
	 * 根据名称获取对应的品种
	 * @param name
	 * @return
	 * @author riseSun
	
	 * 2017年12月26日上午12:52:13
	 */
	public Variety getVarietyByName(String name);
}
