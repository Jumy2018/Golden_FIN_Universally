package com.finuniversally.model;

/**
 * 价格表
 * @author riseSun
 *
 * 2017年12月12日下午10:40:30
 */
public class Prices {
	
	private String symbol;
	private Double bid;
	private Double ask;
	private Double high;
	private Double low;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getBid() {
		return bid;
	}
	public void setBid(Double bid) {
		this.bid = bid;
	}
	public Double getAsk() {
		return ask;
	}
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
}
