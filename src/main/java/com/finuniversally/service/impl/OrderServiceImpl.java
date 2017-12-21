package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.dao.OrderDao;
import com.finuniversally.service.OrderService;
import com.finuniversally.untils.MultipleDataSource;
import com.finuniversally.vo.StatisticsVo;

@Component
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	/**
	 * 获取统计数据
	 */
	@Override
	public StatisticsVo getStaticsVo(String variety) {
		//视图模型
		StatisticsVo statisticsVo = new StatisticsVo();
		
		//多总持仓
		Double multipleTotalHolding = getMultipleTotalHolding(variety);
		statisticsVo.setMultipleTotalHolding(multipleTotalHolding);

		//空总持仓
		Double emptyTotalHolding = getEmptyTotalHolding(variety);
		statisticsVo.setEmptyTotalHolding(emptyTotalHolding);
		
		return statisticsVo;
	}
	/**
	 * 获取多总持仓(cmd=0)
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:18:06
	 */
	@Transactional
	private Double getMultipleTotalHolding(String variety) {
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtys75 = orderDao.getHoldQtys("orders75",variety, 0L);
		Double qtys76 = orderDao.getHoldQtys("orders76",variety, 0L);
		return (qtys75==null ? 0 : qtys75)+(qtys76 == null ? 0:qtys76);
	}
	/**
	 * 获取空总持仓
	 * @param variety
	 * @return
	 * @author riseSun
	
	 * 2017年12月21日下午8:29:24
	 */
	@Transactional
	private Double getEmptyTotalHolding(String variety) {
		//切换香港数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtys75 = orderDao.getHoldQtys("orders75",variety, 1L);
		Double qtys76 = orderDao.getHoldQtys("orders76",variety, 1L);;
		return (qtys75==null ? 0 : qtys75)+(qtys76 == null ? 0:qtys76);
	}
}
