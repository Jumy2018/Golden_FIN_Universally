package com.finuniversally.service;

/**
 * 订单相关业务
 * @author riseSun
 *
 * 2017年12月17日下午7:29:52
 */
public interface OrderService {
	/**
	 * 获取持仓手数
	 * @return
	 * @author riseSun
	
	 * 2017年12月17日下午7:33:41
	 */
	public Double getHoldQtys(Long cmd);
}
