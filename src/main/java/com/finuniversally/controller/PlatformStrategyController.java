package com.finuniversally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finuniversally.model.Account;
import com.finuniversally.model.PlatformStrategy;
import com.finuniversally.service.PlatformStrategyService;

/**
 * 平台策略的控制层
 * @author riseSun
 *
 * 2017年12月28日上午12:29:53
 */
@Controller
public class PlatformStrategyController {
	@Autowired
	PlatformStrategyService platformStrategyService;
	/**
	 * 添加平台策略
	 * @param account
	 * @return
	 * @author riseSun
	
	 * 2017年12月28日上午12:29:41
	 */
	@RequestMapping(value={"/strategy/platform/add"},method={RequestMethod.POST})
	public String add(PlatformStrategy platformStrategy) {
		platformStrategyService.add(platformStrategy);
		return "redirect:/index";
	}
}
