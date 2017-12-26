package com.finuniversally.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.mapper.OrderDao;
import com.finuniversally.service.OrderService;
import com.finuniversally.untils.TransFormDataSource;
import com.finuniversally.vo.StatisticsPlatformVo;
import com.finuniversally.vo.StatisticsVo;

@Component
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderServiceHongKong orderServiceHongKong;
	
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
		Double marketSellPrice = orderServiceHongKong.getMarketPrice("ask", variety);
		statisticsVo.setMarketSellPrice(marketSellPrice);
		//买入市价
		Double marketBuyPrice = orderServiceHongKong.getMarketPrice("bid", variety);
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
			Double marketSellPrice = orderServiceHongKong.getMarketPrice("ask", variety);
			//买入市价
			Double marketBuyPrice = orderServiceHongKong.getMarketPrice("bid", variety);
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
	
	
	
	
	
	
	
	public Double getMultipleTotalHolding(String variety) {
		return orderServiceHongKong.getMultipleTotalHolding(variety);
	}
	public Double getMultipleTotalHolding(String table,String variety) {
		return orderServiceHongKong.getMultipleTotalHolding(table, variety);
	}
	public Double getEmptyTotalHolding(String variety) {
		return orderServiceHongKong.getEmptyTotalHolding(variety);
	}
	public Double getEmptyTotalHolding(String table,String variety) {
		return orderServiceHongKong.getEmptyTotalHolding(table, variety);
	}
	public Double getMultipleTotalPrice(String variety) {
		return orderServiceHongKong.getMultipleTotalPrice(variety);
	}
	public Double getMultipleTotalPrice(String platform,String variety) {
		return orderServiceHongKong.getMultipleTotalPrice(platform, variety);
	}
	public Double getEmptyTotalPrice(String variety) {
		return orderServiceHongKong.getEmptyTotalPrice(variety);
	}
	public Double getEmptyTotalPrice(String platform,String variety) {
		return orderServiceHongKong.getEmptyTotalPrice(platform, variety);
	}
	public Double getOffsetGainAndLoss(String variety) {
		return orderServiceHongKong.getOffsetGainAndLoss(variety);
	}
	public Double getOffsetGainAndLoss(String platform,String variety) {
		return orderServiceHongKong.getOffsetGainAndLoss(platform, variety);
	}
	public Double getNetPositionHourly(String variety) {
		return orderServiceHongKong.getNetPositionHourly(variety);
	}
	public Double getNetPositionHourly(String platform,String variety) {
		return orderServiceHongKong.getNetPositionHourly(variety);
	}
}
