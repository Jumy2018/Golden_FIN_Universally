package com.finuniversally.model;

import java.util.Date;

/**
 * 订单
 * @author riseSun
 *
 * 2017年12月17日下午7:19:20
 */
public class Order {
	//账号
	private Long login;
	//开仓单号
	private Long ticket;
	//商品
	private String symbol;
	//多空(0=多,1=空)
	private Long cmd;
	//手数
	private Double qty;
	//开仓价位
	private Double openPrice;
	//平仓价位
	private Double closePrice;
	//开仓时间
	private Date openTime;
	//平仓时间
	private Date closeTime;
	//平仓盈亏
	private Double profit;
	
	
	//setter,getter...
	public Long getLogin() {
		return login;
	}
	public void setLogin(Long login) {
		this.login = login;
	}
	public Long getTicket() {
		return ticket;
	}
	public void setTicket(Long ticket) {
		this.ticket = ticket;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Long getCmd() {
		return cmd;
	}
	public void setCmd(Long cmd) {
		this.cmd = cmd;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}
	public Double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
}
