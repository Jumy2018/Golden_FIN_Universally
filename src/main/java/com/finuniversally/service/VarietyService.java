package com.finuniversally.service;

import java.util.List;
import com.finuniversally.model.Variety;

/**
 * 品种相关业务
 * @author riseSun
 *
 * 2017年12月14日下午10:20:39
 */
public interface VarietyService {
	public List<Variety> getVarietys();
	/**
	 * 根据名称获取品种
	 * @return
	 * @author riseSun
	
	 * 2017年12月22日下午8:48:47
	 */
	public Variety getVarietyByName(String varietyName);

}
