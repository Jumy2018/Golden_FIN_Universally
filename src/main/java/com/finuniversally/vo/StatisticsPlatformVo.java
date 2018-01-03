package com.finuniversally.vo;

import com.finuniversally.model.CustomerPlatform;

/**
 * 
 * @author riseSun
 * 平台头寸-统计数据区-分平台用
 * 2017年11月29日下午10:51:03
 */
public class StatisticsPlatformVo {
	private CustomerPlatform customerPlatform;//客户数据平台
	private double netPosition; // 净头寸
	private double netPositionHourly; //一小时净头
	private double multipleTotalHolding; //多总持仓  买入手数
	private double emptyTotalHolding;// 空总持仓  卖出手数
	private double middlePrice;// 中间价
	private double multipleTotalAveragePrice;// 多总均价  买入价
	private double emptyTotalAveragePrice;// 空总均价  卖出价
	private double multipleDetonatingPoint;// 多曝点
	private double emptyDetonatingPoint;// 空爆点
	private double totalProfitAndLoss;// 客户总盈亏
	private double offsetGainAndLoss;//平仓盈亏
	private double opsitionGainAndLoss;// 持仓盈亏
	
	//setter,getter...
	/**
	 * 净头寸 = 多总持仓-空总持仓
	 * @return
	 * @author riseSun
	 * 2017年12月13日下午10:08:15
	 */
	public double getNetPosition() {
		return multipleTotalHolding - emptyTotalHolding;
	}

	public double getNetPositionHourly() {
		return netPositionHourly;
	}
	public void setNetPositionHourly(double netPositionHourly) {
		this.netPositionHourly = netPositionHourly;
	}
	public double getMultipleTotalHolding() {
		return multipleTotalHolding;
	}
	public void setMultipleTotalHolding(double multipleTotalHolding) {
		this.multipleTotalHolding = multipleTotalHolding;
	}
	public double getEmptyTotalHolding() {
		return emptyTotalHolding;
	}
	public void setEmptyTotalHolding(double emptyTotalHolding) {
		this.emptyTotalHolding = emptyTotalHolding;
	}
	public double getMiddlePrice() {
		return middlePrice;
	}
	public void setMiddlePrice(double middlePrice) {
		this.middlePrice = middlePrice;
	}
	public double getMultipleTotalAveragePrice() {
		return multipleTotalAveragePrice;
	}
	public void setMultipleTotalAveragePrice(double multipleTotalAveragePrice) {
		this.multipleTotalAveragePrice = multipleTotalAveragePrice;
	}
	public double getEmptyTotalAveragePrice() {
		return emptyTotalAveragePrice;
	}
	public void setEmptyTotalAveragePrice(double emptyTotalAveragePrice) {
		this.emptyTotalAveragePrice = emptyTotalAveragePrice;
	}
	

	/**
	 * 多曝点 = 多总均价 - 13;
	 * @return
	 * @author riseSun
	
	 * 2017年11月29日下午11:07:15
	 */
	public double getMultipleDetonatingPoint() {
		return multipleTotalAveragePrice - 13.0;
	}
	/**
	 * 空爆点 = 多总均价 + 13;
	 * @return
	 * @author riseSun
	
	 * 2017年11月29日下午11:07:41
	 */
	public double getEmptyDetonatingPoint() {
		return multipleTotalAveragePrice + 13.0;
	}
	public double getTotalProfitAndLoss() {
		return offsetGainAndLoss+opsitionGainAndLoss;
	}
	public double getOffsetGainAndLoss() {
		return offsetGainAndLoss;
	}
	public void setOffsetGainAndLoss(double offsetGainAndLoss) {
		this.offsetGainAndLoss = offsetGainAndLoss;
	}
	public double getOpsitionGainAndLoss() {
		return opsitionGainAndLoss;
	}
	public void setOpsitionGainAndLoss(double opsitionGainAndLoss) {
		this.opsitionGainAndLoss = opsitionGainAndLoss;
	}
	public CustomerPlatform getCustomerPlatform() {
		return customerPlatform;
	}
	public void setCustomerPlatform(CustomerPlatform customerPlatform) {
		this.customerPlatform = customerPlatform;
	}
}
