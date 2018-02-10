package com.finuniversally.struct.trade.esunny;

import com.finuniversally.struct.trade.AbstractOrderInfoStruct;

public class OrderInfoStructEsunny extends AbstractOrderInfoStruct{
	
	private TEsOrderInsertReqField reqField;
	private int reqID;
	
	
	public OrderInfoStructEsunny(TEsOrderInsertReqField reqField, int reqID) {
		super();
		this.reqField = reqField;
		this.reqID = reqID;
	}
	
	public TEsOrderInsertReqField getReqField() {
		return reqField;
	}
	public void setReqField(TEsOrderInsertReqField reqField) {
		this.reqField = reqField;
	}
	public int getReqID() {
		return reqID;
	}
	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	
}
