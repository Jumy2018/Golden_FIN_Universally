package com.finuniversally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.finuniversally.api.impl.SharpPointApiImpl;
import com.finuniversally.service.TradeService;
import com.finuniversally.struct.trade.AbstractLoginInfoStruct;
import com.finuniversally.struct.trade.AbstractOpenInfoStruct;
import com.finuniversally.struct.trade.AbstractOrderInfoStruct;
import com.finuniversally.struct.trade.esunny.TEsAddressField;
import com.finuniversally.struct.trade.esunny.TEsLoginReqField;
import com.finuniversally.struct.trade.esunny.TEsOrderInsertReqField;
import com.finuniversally.struct.trade.sharppoint.LoginInfoStructSp;
import com.finuniversally.struct.trade.sharppoint.OrderInfoStructSp;

/**
 * Thrade on Sharp Point System
 * @author riseSun
 *
 * 2018年2月10日下午8:50:19
 */
/**
 * @author riseSun
 *
 * 2018年2月10日下午9:29:51
 */
public class TradeServiceSharpPointImpl implements TradeService{
	
	@Autowired
	private SharpPointApiImpl sharpPointApiImpl;

	@Override
	public int login(AbstractLoginInfoStruct loginInfo) {
		return sharpPointApiImpl.login((LoginInfoStructSp)loginInfo);
	}

	@Override
	public boolean open(AbstractOpenInfoStruct abstractOpenInfoStruct) {
		return false;
	}

	@Override
	public int orderInsert(AbstractOrderInfoStruct abstractOrderInfoStruct) {
		return sharpPointApiImpl.addOrder((OrderInfoStructSp)abstractOrderInfoStruct);
	}

}
