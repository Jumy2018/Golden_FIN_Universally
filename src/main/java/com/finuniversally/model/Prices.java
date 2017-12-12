package com.finuniversally.model;

import com.finuniversally.untils.Column;

public class Prices {
	
	@Column(name="sysmbol")
	private String symbol;
	@Column(name="bid")
	private Double bid;
	@Column(name="ask")
	private Double ask;
	@Column(name="high")
	private Double high;
	@Column(name="low")
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
