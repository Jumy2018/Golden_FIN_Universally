package com.finuniversally.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finuniversally.model.Variety;
import com.finuniversally.service.OrderService;
import com.finuniversally.service.VarietyService;
import com.finuniversally.untils.MultipleDataSource;
import com.finuniversally.vo.StatisticsVo;

/**
 * 平台头寸页面相关请求
 * @author riseSun
 *
 * 2017年12月21日下午7:53:44
 */
@Controller
public class PlatformCashController {
	//日志
	private static final Logger log = Logger.getLogger(PlatformCashController.class.getName());
	
	@Autowired
	private VarietyService  varietyService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model,@RequestParam String varietyName) throws Exception{
		Variety variety = varietyService.getVarietyByName(varietyName);
		//获取统计数据
		StatisticsVo statisticsVo = orderService.getStaticsVo(variety.getVarietyCode());
		model.addAttribute("statisticsVo", statisticsVo);
		return "test";
	}
	
	@RequestMapping(value={"/"},method={RequestMethod.GET})
	public String test() {
		System.out.println("test");
		return "test";
	}
}
