package com.finuniversally.service;

import java.util.List;

import com.finuniversally.vo.StatisticsPlatformVo;
import com.finuniversally.vo.StatisticsVo;

/**
 * 订单相关业务
 * @author riseSun
 *
 * 2017年12月17日下午7:29:52
 */
public interface OrderService{
	/**
	 * 获取仪表盘数据(统计数据)
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:15:12
	 */
	public StatisticsVo getStaticsVo(String variety);
	
	/**
	 * 获取平台头寸表格数据
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月24日下午2:18:36
	 */
	public List<StatisticsPlatformVo> getStatisticsPlatformVoList(String variety);
}
