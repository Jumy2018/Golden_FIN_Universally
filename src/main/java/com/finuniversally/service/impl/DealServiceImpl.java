package com.finuniversally.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.model.DealData;
import com.finuniversally.service.DealService;
import com.finuniversally.service.OrderService;

/**
 * 处理交易的业务逻辑
 * @author riseSun
 *
 * 2018年1月5日下午8:30:59
 */
//@Component()
public class DealServiceImpl implements DealService,Runnable{

	private String socketData;
	private String platformName;
	
	@Autowired
	private OrderService orderService;

	public DealServiceImpl(String socketData,String platformName) {
		this.socketData = socketData;
		this.platformName = platformName;
	}

	@Override
	public DealData constructor(String dealMsg) {
		String[] splitArr = dealMsg.split(";");
		int index = 0;
		DealData dealData = new DealData();
		try {
			dealData.setHead(splitArr[index++]);//头
			dealData.setAccount(splitArr[index++]);//账号
			dealData.setOpenOrderNum(splitArr[index++]);//开仓单号
			dealData.setNewOpenOrderNum(splitArr[index++]);//新开仓单号
			dealData.setVarietyCode(splitArr[index++]);//商品
			dealData.setCounts(Double.parseDouble(splitArr[index++]));//手数
			dealData.setPrice(Double.parseDouble(splitArr[index++]));//价位
			Date createTime = new SimpleDateFormat("yyyymmddHHmiss").parse(splitArr[index++]);
			dealData.setCreateTime(createTime);//时间
			dealData.setCmd(Integer.parseInt(splitArr[index++]));//多空
			dealData.setOpenClose(Integer.parseInt(splitArr[index++]));//开平
			dealData.setProfit(Double.parseDouble(splitArr[index++]));//平仓盈亏
		}catch (Exception e) {
			//数据的构造失败，毁灭当前信息
			e.printStackTrace();
			Logger.getLogger(this.getClass()).error("数据的构造失败，毁灭当前信息");
		}
		return dealData;
	}

	@Override
	public String madeAnOrder(DealData dealData) {
		return null;
	}

	@Override
	public Boolean needAnOrder(DealData dealData) {
		//获取平台当前净头寸
		Double netPosition = orderService.getNetPosition(platformName, dealData.getVarietyCode());
		//获取
		//平台自动下单
		//1. 
		return null;
	}

	@Override
	public void run() {
		//构造下单数据
		DealData dealData = constructor(socketData);
		//是否需要下单
		Boolean needAnOrder = needAnOrder(dealData);
		//下单
		if(needAnOrder) {
			madeAnOrder(dealData);
		}
	}

}
