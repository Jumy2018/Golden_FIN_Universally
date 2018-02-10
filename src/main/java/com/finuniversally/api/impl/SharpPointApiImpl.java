package com.finuniversally.api.impl;

import com.finuniversally.struct.trade.sharppoint.LoginInfoStructSp;
import com.finuniversally.struct.trade.sharppoint.OrderInfoStructSp;

/**
 * 此类用于(SP接口所有函数的)本地方法实现
 * @author riseSun
 *
 * 2018年2月10日下午10:14:01
 */
public class SharpPointApiImpl {
	/**
	 * 
	 * @param loginInfo
	 * @return 0 代表成功发送登录请求
	 * @author riseSun
	
	 * 2018年2月10日下午9:57:14
	 */
	public native int login(LoginInfoStructSp loginInfo);
	
	/**
	 * 退出登录
	 * @param userId
	 * @return 0 代表成功发送请求
	 * @author riseSun
	
	 * 2018年2月10日下午9:58:49
	 */
	public native int loginOut(String userId);
	/**
	 * 下单
	 * @param orderInfo
	 * @return
	 * @author riseSun
	
	 * 2018年2月10日下午10:13:51
	 */
	public native int addOrder(OrderInfoStructSp orderInfo);
}