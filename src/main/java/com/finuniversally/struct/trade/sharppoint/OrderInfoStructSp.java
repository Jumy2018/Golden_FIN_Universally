package com.finuniversally.struct.trade.sharppoint;

import com.finuniversally.struct.trade.AbstractOrderInfoStruct;

/**
 * SP接口下单用结构体(参数)
 * @author riseSun
 *
 * 2018年2月10日下午10:12:07
 */
public class OrderInfoStructSp extends AbstractOrderInfoStruct{
	
	private double price;			//价格
	private double stopLevel;		//止损价格
	private double upLevel;			//上限水平
	private double upPrice;			//上限价格
	private double downLevel;		//下限水平
	private double downPrice;		//下限价格 
	private long extOrderNo;		//外部指示
	private int intOrderNo;			//用户订单编号
	private int qty;				//剩下数量
	private int	tradedQty;			//已成交数量
	private int	totalQty;			//订单全部数量
	private int validTime; 			//有效时间
	private int schedTime; 			//预订发送时间
	private int timeStamp; 			//服务器接收订单时间
	private long orderOptions; 		//0=默认,1=T+1（参考第四部分：1.2）
	private String accNo;			//用户帐号
	private String prodCode; 		//合约代号
	private String initiator; 		//下单用户
	private String ref; 			//参考
	private String ref2; 			//参考
	private String gatewayCode; 	//网关
	private String clOrderId; 		//用户自定义参考
	private char buySell; 			//买卖方向（参考第四部分：1.1）
	private char stopType; 			//止损类型
	private char openClose; 		//开平仓
	private int condType; 			//订单条件类型
	private int orderType; 			//订单类型
	private int validType; 			//订单有效类型
	private int status; 			//状态
	private int decInPrice; 		//合约小数位
	private int orderAction;
	private int updateTime;
	private int updateSeqNo;
	
	public OrderInfoStructSp(double price, double stopLevel, double upLevel, double upPrice, double downLevel,
			double downPrice, long extOrderNo, int intOrderNo, int qty, int tradedQty, int totalQty, int validTime,
			int schedTime, int timeStamp, long orderOptions, String accNo, String prodCode, String initiator,
			String ref, String ref2, String gatewayCode, String clOrderId, char buySell, char stopType, char openClose,
			int condType, int orderType, int validType, int status, int decInPrice, int orderAction, int updateTime,
			int updateSeqNo) {
		super();
		this.price = price;
		this.stopLevel = stopLevel;
		this.upLevel = upLevel;
		this.upPrice = upPrice;
		this.downLevel = downLevel;
		this.downPrice = downPrice;
		this.extOrderNo = extOrderNo;
		this.intOrderNo = intOrderNo;
		this.qty = qty;
		this.tradedQty = tradedQty;
		this.totalQty = totalQty;
		this.validTime = validTime;
		this.schedTime = schedTime;
		this.timeStamp = timeStamp;
		this.orderOptions = orderOptions;
		this.accNo = accNo;
		this.prodCode = prodCode;
		this.initiator = initiator;
		this.ref = ref;
		this.ref2 = ref2;
		this.gatewayCode = gatewayCode;
		this.clOrderId = clOrderId;
		this.buySell = buySell;
		this.stopType = stopType;
		this.openClose = openClose;
		this.condType = condType;
		this.orderType = orderType;
		this.validType = validType;
		this.status = status;
		this.decInPrice = decInPrice;
		this.orderAction = orderAction;
		this.updateTime = updateTime;
		this.updateSeqNo = updateSeqNo;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getStopLevel() {
		return stopLevel;
	}
	public void setStopLevel(double stopLevel) {
		this.stopLevel = stopLevel;
	}
	public double getUpLevel() {
		return upLevel;
	}
	public void setUpLevel(double upLevel) {
		this.upLevel = upLevel;
	}
	public double getUpPrice() {
		return upPrice;
	}
	public void setUpPrice(double upPrice) {
		this.upPrice = upPrice;
	}
	public double getDownLevel() {
		return downLevel;
	}
	public void setDownLevel(double downLevel) {
		this.downLevel = downLevel;
	}
	public double getDownPrice() {
		return downPrice;
	}
	public void setDownPrice(double downPrice) {
		this.downPrice = downPrice;
	}
	public long getExtOrderNo() {
		return extOrderNo;
	}
	public void setExtOrderNo(long extOrderNo) {
		this.extOrderNo = extOrderNo;
	}
	public int getIntOrderNo() {
		return intOrderNo;
	}
	public void setIntOrderNo(int intOrderNo) {
		this.intOrderNo = intOrderNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTradedQty() {
		return tradedQty;
	}
	public void setTradedQty(int tradedQty) {
		this.tradedQty = tradedQty;
	}
	public int getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}
	public int getValidTime() {
		return validTime;
	}
	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}
	public int getSchedTime() {
		return schedTime;
	}
	public void setSchedTime(int schedTime) {
		this.schedTime = schedTime;
	}
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getOrderOptions() {
		return orderOptions;
	}
	public void setOrderOptions(long orderOptions) {
		this.orderOptions = orderOptions;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getRef2() {
		return ref2;
	}
	public void setRef2(String ref2) {
		this.ref2 = ref2;
	}
	public String getGatewayCode() {
		return gatewayCode;
	}
	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}
	public String getClOrderId() {
		return clOrderId;
	}
	public void setClOrderId(String clOrderId) {
		this.clOrderId = clOrderId;
	}
	public char getBuySell() {
		return buySell;
	}
	public void setBuySell(char buySell) {
		this.buySell = buySell;
	}
	public char getStopType() {
		return stopType;
	}
	public void setStopType(char stopType) {
		this.stopType = stopType;
	}
	public char getOpenClose() {
		return openClose;
	}
	public void setOpenClose(char openClose) {
		this.openClose = openClose;
	}
	public int getCondType() {
		return condType;
	}
	public void setCondType(int condType) {
		this.condType = condType;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getValidType() {
		return validType;
	}
	public void setValidType(int validType) {
		this.validType = validType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDecInPrice() {
		return decInPrice;
	}
	public void setDecInPrice(int decInPrice) {
		this.decInPrice = decInPrice;
	}
	public int getOrderAction() {
		return orderAction;
	}
	public void setOrderAction(int orderAction) {
		this.orderAction = orderAction;
	}
	public int getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdateSeqNo() {
		return updateSeqNo;
	}
	public void setUpdateSeqNo(int updateSeqNo) {
		this.updateSeqNo = updateSeqNo;
	}
}