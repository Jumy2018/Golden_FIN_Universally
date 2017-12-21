package com.finuniversally.vo;

/**
 * 
 * @author riseSun
 * 平台头寸-统计数据区
 * 2017年11月29日下午10:51:03
 */
public class StatisticsVo {
	private double netPosition; // 净头寸
	private double netPositionHourly; //一小时净头寸
	private double multipleTotalHolding; //多总持仓
	private double emptyTotalHolding;// 空总持仓
	private double middlePrice;// 中间价
	private double multipleTotalAveragePrice;// 多总均价
	private double emptyTotalAveragePrice;// 空总均价
	private double marketPrice;// 市价
	private double multipleDetonatingPoint;// 多曝点
	private double emptyDetonatingPoint;// 空爆点
	private double totalProfitAndLoss;// 空户总盈亏
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
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
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
		return totalProfitAndLoss;
	}
	public void setTotalProfitAndLoss(double totalProfitAndLoss) {
		this.totalProfitAndLoss = totalProfitAndLoss;
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
}
