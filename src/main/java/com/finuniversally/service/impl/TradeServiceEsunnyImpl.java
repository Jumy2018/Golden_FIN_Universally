package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.finuniversally.api.impl.EsunnyApiImpl;
import com.finuniversally.service.TradeService;
import com.finuniversally.struct.trade.AbstractLoginInfoStruct;
import com.finuniversally.struct.trade.AbstractOpenInfoStruct;
import com.finuniversally.struct.trade.AbstractOrderInfoStruct;
import com.finuniversally.struct.trade.esunny.LoginInfoStructEsunny;
import com.finuniversally.struct.trade.esunny.OpenInfoStructEsunny;
import com.finuniversally.struct.trade.esunny.OrderInfoStructEsunny;
import com.finuniversally.struct.trade.esunny.TEsAddressField;
import com.finuniversally.struct.trade.esunny.TEsOrderInsertReqField;

public class TradeServiceEsunnyImpl implements TradeService{

	@Autowired
	private EsunnyApiImpl esunnyApiImpl;
	
	@Override
	public boolean open(AbstractOpenInfoStruct openInfoStruct) {
		OpenInfoStructEsunny openInfo = (OpenInfoStructEsunny)openInfoStruct;
		return esunnyApiImpl.open(openInfo.getAddr(), openInfo.getAppID(), openInfo.getCer());
	}

	@Override
	public int login(AbstractLoginInfoStruct loginInfoStruct) {
		LoginInfoStructEsunny loginInfo = (LoginInfoStructEsunny)loginInfoStruct;
		return esunnyApiImpl.login(loginInfo.getField(), loginInfo.getReqId());
	}

	@Override
	public int orderInsert(AbstractOrderInfoStruct orderInfoStruct) {
		OrderInfoStructEsunny orderInfo = (OrderInfoStructEsunny)orderInfoStruct;
		return esunnyApiImpl.orderInsert(orderInfo.getReqField(), orderInfo.getReqID());
	}

}
