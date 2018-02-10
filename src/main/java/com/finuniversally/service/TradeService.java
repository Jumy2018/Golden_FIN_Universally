package com.finuniversally.service;

import com.finuniversally.struct.trade.AbstractLoginInfoStruct;
import com.finuniversally.struct.trade.AbstractOpenInfoStruct;
import com.finuniversally.struct.trade.AbstractOrderInfoStruct;
import com.finuniversally.struct.trade.esunny.TEsAddressField;
import com.finuniversally.struct.trade.esunny.TEsOrderInsertReqField;

/**
 * @author riseSun
 *
 * 2018年1月24日下午7:37:06
 */
public interface TradeService {
	/**
	 * 建立连接
	 * @param addr
	 * @return
	 * @author riseSun
	
	 * 2018年1月24日下午11:04:47
	 */
	public boolean open(AbstractOpenInfoStruct abstractOpenInfoStruct);
	/**
	 * 登录
	 * @param field
	 * @param iReqId
	 * @return
	 * @author riseSun
	
	 * 2018年1月24日下午11:03:06
	 */
	public int login(AbstractLoginInfoStruct loginInfoStruct);
	
	/**
	 * 下单请求
	 * @return
	 * @author riseSun
	
	 * 2018年1月24日下午11:11:24
	 */
	public int orderInsert(AbstractOrderInfoStruct abstractOrderInfoStruct);
	
}
