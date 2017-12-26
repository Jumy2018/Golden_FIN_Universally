package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.mapper.OrderDao;
import com.finuniversally.untils.TransFormDataSource;


@Component
public class OrderServiceHongKong{
	
	@Autowired
	protected OrderDao orderDao;
	/**
	 * 获取多总持仓(cmd=0)
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:18:06
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getMultipleTotalHolding(String variety) {
		Double qtys75 = orderDao.getHoldQtys("orders75",variety, 0L);
		Double qtys76 = orderDao.getHoldQtys("orders76",variety, 0L);
		Double qtys = (qtys75==null ? 0 : qtys75)+(qtys76 == null ? 0:qtys76);
		return qtys;
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getMultipleTotalHolding(String table,String variety) {
		Double qtys = orderDao.getHoldQtys(table,variety, 0L);
		return (qtys==null ? 0 : qtys);
	}
	
	/**
	 * 获取空总持仓
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:29:24
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getEmptyTotalHolding(String variety) {
		Double qtys75 = orderDao.getHoldQtys("orders75",variety, 1L);
		Double qtys76 = orderDao.getHoldQtys("orders76",variety, 1L);
		return (qtys75==null ? 0 : qtys75)+(qtys76 == null ? 0:qtys76);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getEmptyTotalHolding(String platform,String variety) {
		Double qtys = orderDao.getHoldQtys(platform,variety, 1L);
		return (qtys==null ? 0 : qtys);
	}
	/**
	 * 获取多总价
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getMultipleTotalPrice(String variety) {
		Double totalPrice75 = orderDao.getTotalPrice("orders75", variety, 0L);
		Double totalPrice76 = orderDao.getTotalPrice("orders76", variety, 0L);
		return (totalPrice75==null ? 0 : totalPrice75)+(totalPrice76 == null ? 0:totalPrice76);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getMultipleTotalPrice(String platform,String variety) {
		Double totalPrice = orderDao.getTotalPrice(platform, variety, 0L);
		return (totalPrice==null ? 0 : totalPrice);
	}
	/**
	 * 获得空总价
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getEmptyTotalPrice(String variety) {
		Double totalPrice75 = orderDao.getTotalPrice("orders75", variety, 1L);
		Double totalPrice76 = orderDao.getTotalPrice("orders76", variety, 1L);
		return (totalPrice75==null ? 0 : totalPrice75)+(totalPrice76 == null ? 0:totalPrice76);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getEmptyTotalPrice(String platform,String variety) {
		Double totalPrice = orderDao.getTotalPrice(platform, variety, 1L);
		return (totalPrice==null ? 0 : totalPrice);
	}
	
	/**
	 * 平仓盈亏
	 * 
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getOffsetGainAndLoss(String variety) {
		Double offsetGainAndLoss75 = orderDao.getOffsetGainAndLoss("orders75", variety);
		Double offsetGainAndLoss76 = orderDao.getOffsetGainAndLoss("orders76", variety);
		return (offsetGainAndLoss75==null ? 0 : offsetGainAndLoss75)+(offsetGainAndLoss76 == null ? 0:offsetGainAndLoss76);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getOffsetGainAndLoss(String platform,String variety) {
		Double offsetGainAndLoss = orderDao.getOffsetGainAndLoss(platform, variety);
		return (offsetGainAndLoss==null ? 0 : offsetGainAndLoss);
	}
	/**
	 * 获取一小时头寸 = 一小时(多总持仓-空总持仓)
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午10:50:16
	 */
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getNetPositionHourly(String variety) {
		Double qtys75NetPositionHourly = orderDao.getNetPositionHourly("orders75",variety);
		Double qtys76NetPositionHourly = orderDao.getNetPositionHourly("orders76",variety);
		return (qtys75NetPositionHourly==null ? 0 : qtys75NetPositionHourly)+(qtys76NetPositionHourly == null ? 0:qtys76NetPositionHourly);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getNetPositionHourly(String platform,String variety) {
		Double qtysNetPositionHourly = orderDao.getNetPositionHourly(platform,variety);
		return (qtysNetPositionHourly==null ? 0 : qtysNetPositionHourly);
	}
	@TransFormDataSource(name="dataSourceHongKong")
	public Double getMarketPrice(String type, String variety) {
		return orderDao.getMarketPrice(type, variety);
	}
}
