package com.finuniversally.api.impl;

import com.finuniversally.struct.trade.esunny.TEsAddressField;
import com.finuniversally.struct.trade.esunny.TEsLoginReqField;
import com.finuniversally.struct.trade.esunny.TEsOrderInsertReqField;

public class EsunnyApiImpl {

	/**
	 * 建立连接
	 * @param addr
	 * @param appID
	 * @param cer
	 * @return
	 * @author riseSun
	
	 * 2018年2月10日下午10:49:00
	 */
	public native boolean open(TEsAddressField addr,String appID,String cer);
	/**
	 * 登录
	 * @param field
	 * @param iReqId
	 * @return
	 * @author riseSun
	
	 * 2018年2月10日下午10:49:05
	 */
	public native int login(TEsLoginReqField field, String iReqId);
	/**
	 * 下单
	 * @param req
	 * @param iReqID
	 * @return
	 * @author riseSun
	
	 * 2018年2月10日下午10:49:13
	 */
	public native int orderInsert(TEsOrderInsertReqField req, int iReqID);
	
}
