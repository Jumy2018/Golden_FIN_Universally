package com.finuniversally.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finuniversally.model.Account;
import com.finuniversally.model.AccountVo;
import com.finuniversally.model.TradePlatform;
import com.finuniversally.model.Variety;
import com.finuniversally.service.AccountService;
import com.finuniversally.service.OrderService;
import com.finuniversally.service.TradePlatformService;
import com.finuniversally.service.VarietyService;
import com.finuniversally.vo.StatisticsPlatformVo;
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
	@Autowired
	private TradePlatformService platformService;
	@Autowired 
	private AccountService accountService;
	
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model,@RequestParam(required=false) String varietyName) throws Exception{
		List<Variety> varietyList = varietyService.getVarietys();
		if(varietyName == null) {
			varietyName = varietyList.get(0).getVarietyName();
		}
		Variety variety = varietyService.getVarietyByName(varietyName);

		//将品种暂存到页面
		model.addAttribute("seletedVariety",variety);
	
		//获取统计数据
		StatisticsVo statisticsVo = orderService.getStaticsVo(variety.getVarietyCode());
		List<StatisticsPlatformVo> staList = orderService.getStatisticsPlatformVoList(variety.getVarietyCode());
		model.addAttribute("statisticsVo", statisticsVo);
		model.addAttribute("varietyList",varietyList);
		model.addAttribute("staList",staList);

		//获取所有交易平台
		List<TradePlatform> tradeFormList = platformService.getAllPlatform();
		model.addAttribute("tradePlatformList",tradeFormList);
		//获取所有的交易账户
		List<AccountVo> allAccounts = accountService.getAllAccounts();
		model.addAttribute("allAccounts",allAccounts);
		
		return "test";
	}
	
	@RequestMapping(value={"/"},method={RequestMethod.GET})
	public String test() {
		System.out.println("test");
		return "test2";
	}
}
