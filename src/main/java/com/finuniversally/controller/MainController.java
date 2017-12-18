package com.finuniversally.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finuniversally.model.Variety;
import com.finuniversally.service.OrderService;
import com.finuniversally.service.VarietyService;
import com.finuniversally.untils.MultipleDataSource;

@Controller
public class MainController {
	//日志
	private static final Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private VarietyService varietyService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value={"/"},method={RequestMethod.GET})
	public String head() {
		List<Variety> varietys = varietyService.getVarietys();
		for(Variety variety: varietys) {
			System.out.println(variety.getVarietyName());
		}
		MultipleDataSource.setDataSourceKey("dataSourceHongKong");
		Double holdQtys = orderService.getHoldQtys(new Long(1));
		System.out.println("75平台:"+holdQtys);
		return "index";
	}
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index() throws Exception{
		return "index";
	}
}
