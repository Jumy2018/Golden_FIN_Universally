package com.finuniversally.service;

import com.finuniversally.vo.StatisticsVo;

/**
 * 订单相关业务
 * @author riseSun
 *
 * 2017年12月17日下午7:29:52
 */
public interface OrderService {
	/**
	 * 获取仪表盘数据(统计数据)
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:15:12
	 */
	public StatisticsVo getStaticsVo(String variety);
}
