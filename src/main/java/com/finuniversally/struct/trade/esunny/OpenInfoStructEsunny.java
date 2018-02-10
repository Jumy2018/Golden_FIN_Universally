package com.finuniversally.struct.trade.esunny;

import com.finuniversally.struct.trade.AbstractOpenInfoStruct;

public class OpenInfoStructEsunny extends AbstractOpenInfoStruct{

	private TEsAddressField addr;
	private String appID;
	private String cer;
	
	public OpenInfoStructEsunny(TEsAddressField addr, String appID, String cer) {
		super();
		this.addr = addr;
		this.appID = appID;
		this.cer = cer;
	}
	
	public TEsAddressField getAddr() {
		return addr;
	}
	public void setAddr(TEsAddressField addr) {
		this.addr = addr;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getCer() {
		return cer;
	}
	public void setCer(String cer) {
		this.cer = cer;
	}

	
}
