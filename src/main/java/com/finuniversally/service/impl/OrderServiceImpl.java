package com.finuniversally.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.dao.OrderDao;
import com.finuniversally.service.OrderService;
import com.finuniversally.untils.MultipleDataSource;
import com.finuniversally.vo.StatisticsPlatformVo;
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

		//1小时头寸
		Double netPositionHourly = getNetPositionHourly(variety);
		statisticsVo.setNetPositionHourly(netPositionHourly);
		//多总价
		Double multipleTotalPrice = getMultipleTotalPrice(variety);
		//空总价
		Double emptyTotalPrice = getEmptyTotalPrice(variety);
		//多总均价
		statisticsVo.setMultipleTotalAveragePrice(multipleTotalPrice/multipleTotalHolding);
		//空总均价
		statisticsVo.setEmptyTotalAveragePrice(emptyTotalPrice/emptyTotalHolding);
		//中间价
		statisticsVo.setMiddlePrice((multipleTotalPrice+emptyTotalPrice)/(multipleTotalHolding+emptyTotalHolding));
		//卖出市价
		Double marketSellPrice = orderDao.getMarketPrice("ask", variety);
		statisticsVo.setMarketSellPrice(marketSellPrice);
		//买入市价
		Double marketBuyPrice = orderDao.getMarketPrice("bid", variety);
		statisticsVo.setMarketBuyPrice(marketBuyPrice);
		//平仓盈亏
		Double offsetGainAndLoss = getOffsetGainAndLoss(variety);
		statisticsVo.setOffsetGainAndLoss(offsetGainAndLoss);
		
		//做多持仓盈亏
		Double multipleGainAndLoss = multipleTotalHolding*marketSellPrice-multipleTotalPrice;
		//做空持仓盈亏
		Double emptyGainAndLoss = emptyTotalPrice-emptyTotalHolding*marketBuyPrice;
		statisticsVo.setOpsitionGainAndLoss(multipleGainAndLoss+emptyGainAndLoss);
			
		return statisticsVo;
	}
	
	/**
	 * 获取页面表格数据
	 */
	@Override
	public List<StatisticsPlatformVo> getStatisticsPlatformVoList(String variety){
		List<StatisticsPlatformVo> statisticsPlatformVoList = new ArrayList<StatisticsPlatformVo>();
		String[] paltform = {"orders75","orders76"};
		for(int i=0;i<paltform.length;i++) {
			StatisticsPlatformVo statisticsPlatformVo = new StatisticsPlatformVo();
			statisticsPlatformVo.setPlatformName(paltform[i]);
			//多总持仓
			Double multipleTotalHolding = getMultipleTotalHolding(paltform[i],variety);
			statisticsPlatformVo.setMultipleTotalHolding(multipleTotalHolding);
			//空总持仓
			Double emptyTotalHolding = getEmptyTotalHolding(paltform[i],variety);
			statisticsPlatformVo.setEmptyTotalHolding(emptyTotalHolding);
			//1小时头寸
			Double netPositionHourly = getNetPositionHourly(paltform[i],variety);
			statisticsPlatformVo.setNetPositionHourly(netPositionHourly);
			//多总价
			Double multipleTotalPrice = getMultipleTotalPrice(paltform[i],variety);
			//空总价
			Double emptyTotalPrice = getEmptyTotalPrice(paltform[i],variety);
			//多总均价
			statisticsPlatformVo.setMultipleTotalAveragePrice(multipleTotalHolding==0?0:multipleTotalPrice/multipleTotalHolding);
			//空总均价
			statisticsPlatformVo.setEmptyTotalAveragePrice(emptyTotalHolding==0?0:emptyTotalPrice/emptyTotalHolding);
			//中间价
			statisticsPlatformVo.setMiddlePrice((multipleTotalPrice+emptyTotalPrice)/(multipleTotalHolding+emptyTotalHolding));
			//卖出市价
			Double marketSellPrice = orderDao.getMarketPrice("ask", variety);
			//买入市价
			Double marketBuyPrice = orderDao.getMarketPrice("bid", variety);
			//平仓盈亏
			Double offsetGainAndLoss = getOffsetGainAndLoss(paltform[i],variety);
			statisticsPlatformVo.setOffsetGainAndLoss(offsetGainAndLoss);
			//做多持仓盈亏
			Double multipleGainAndLoss = multipleTotalHolding*marketSellPrice-multipleTotalPrice;
			//做空持仓盈亏
			Double emptyGainAndLoss = emptyTotalPrice-emptyTotalHolding*marketBuyPrice;
			statisticsPlatformVo.setOpsitionGainAndLoss(multipleGainAndLoss+emptyGainAndLoss);
			statisticsPlatformVoList.add(statisticsPlatformVo);
		}
		return statisticsPlatformVoList;
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
	@Transactional
	private Double getMultipleTotalHolding(String platform,String variety) {
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtys = orderDao.getHoldQtys(platform,variety, 0L);
		return (qtys==null ? 0 : qtys);
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
		Double qtys76 = orderDao.getHoldQtys("orders76",variety, 1L);
		return (qtys75==null ? 0 : qtys75)+(qtys76 == null ? 0:qtys76);
	}
	@Transactional
	private Double getEmptyTotalHolding(String platform,String variety) {
		//切换香港数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtys = orderDao.getHoldQtys(platform,variety, 1L);
		return (qtys==null ? 0 : qtys);
	}
	/**
	 * 获取多总价
	 */
	@Transactional
	private Double getMultipleTotalPrice(String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double totalPrice75 = orderDao.getTotalPrice("orders75", variety, 0L);
		Double totalPrice76 = orderDao.getTotalPrice("orders76", variety, 0L);
		return (totalPrice75==null ? 0 : totalPrice75)+(totalPrice76 == null ? 0:totalPrice76);
	}
	@Transactional
	private Double getMultipleTotalPrice(String platform,String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double totalPrice = orderDao.getTotalPrice(platform, variety, 0L);
		return (totalPrice==null ? 0 : totalPrice);
	}
	/**
	 * 获得空总价
	 */
	@Transactional
	private Double getEmptyTotalPrice(String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double totalPrice75 = orderDao.getTotalPrice("orders75", variety, 1L);
		Double totalPrice76 = orderDao.getTotalPrice("orders76", variety, 1L);
		return (totalPrice75==null ? 0 : totalPrice75)+(totalPrice76 == null ? 0:totalPrice76);
	}
	@Transactional
	private Double getEmptyTotalPrice(String platform,String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double totalPrice = orderDao.getTotalPrice(platform, variety, 1L);
		return (totalPrice==null ? 0 : totalPrice);
	}
	
	/**
	 * 平仓盈亏
	 * 
	 */
	@Transactional
	public Double getOffsetGainAndLoss(String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double offsetGainAndLoss75 = orderDao.getOffsetGainAndLoss("orders75", variety);
		Double offsetGainAndLoss76 = orderDao.getOffsetGainAndLoss("orders76", variety);
		return (offsetGainAndLoss75==null ? 0 : offsetGainAndLoss75)+(offsetGainAndLoss76 == null ? 0:offsetGainAndLoss76);
	}
	@Transactional
	public Double getOffsetGainAndLoss(String platform,String variety) {
		//切换香港的数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
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
	@Transactional
	public Double getNetPositionHourly(String variety) {
		//切换香港数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtys75NetPositionHourly = orderDao.getNetPositionHourly("orders75",variety);
		Double qtys76NetPositionHourly = orderDao.getNetPositionHourly("orders76",variety);
		return (qtys75NetPositionHourly==null ? 0 : qtys75NetPositionHourly)+(qtys76NetPositionHourly == null ? 0:qtys76NetPositionHourly);
	}
	@Transactional
	public Double getNetPositionHourly(String platform,String variety) {
		//切换香港数据库
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double qtysNetPositionHourly = orderDao.getNetPositionHourly(platform,variety);
		return (qtysNetPositionHourly==null ? 0 : qtysNetPositionHourly);
	}
}
