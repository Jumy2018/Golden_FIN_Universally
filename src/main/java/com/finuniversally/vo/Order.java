package com.finuniversally.vo;

/**
 * 用户下单的数据
 * @author riseSun
 *
 * 2017年12月9日下午11:22:37
 */
public class Order {
	//头
	private String header;
	//账号
	private String account;
	//开仓单号
	private String openRepoNum;
	//新开仓单号
	private String newOpenRepoNum;
	//商品
	private String goods;
	//手数
	private String orderNums;
	//价位
	private String price;
	//时间
	private String time;//因为解析数据要的时间过得
	//多空
	private String longShort; 
	//开平
	private String openClose;
	//平仓盈亏
	private String profit;

	//setter,getter...
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOpenRepoNum() {
		return openRepoNum;
	}
	public void setOpenRepoNum(String openRepoNum) {
		this.openRepoNum = openRepoNum;
	}
	public String getNewOpenRepoNum() {
		return newOpenRepoNum;
	}
	public void setNewOpenRepoNum(String newOpenRepoNum) {
		this.newOpenRepoNum = newOpenRepoNum;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getOrderNums() {
		return orderNums;
	}
	public void setOrderNums(String orderNums) {
		this.orderNums = orderNums;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLongShort() {
		return longShort;
	}
	public void setLongShort(String longShort) {
		this.longShort = longShort;
	}
	public String getOpenClose() {
		return openClose;
	}
	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
}
