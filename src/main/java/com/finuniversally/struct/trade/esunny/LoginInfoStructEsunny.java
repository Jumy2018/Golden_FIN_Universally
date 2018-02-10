package com.finuniversally.struct.trade.esunny;

import com.finuniversally.struct.trade.AbstractLoginInfoStruct;

public class LoginInfoStructEsunny extends AbstractLoginInfoStruct{

	private TEsLoginReqField field;
	private String reqId;
	
	public LoginInfoStructEsunny(TEsLoginReqField field, String reqId) {
		super();
		this.field = field;
		this.reqId = reqId;
	}

	public TEsLoginReqField getField() {
		return field;
	}
	public void setField(TEsLoginReqField field) {
		this.field = field;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
}
