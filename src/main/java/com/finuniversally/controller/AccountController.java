package com.finuniversally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finuniversally.model.Account;
import com.finuniversally.service.AccountService;

/**
 * 
 * 交易账号管理控制器
 * @author riseSun
 *
 * 2017年12月23日下午3:45:03
 */
@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value={"/account/add"},method={RequestMethod.POST})
	public String add(Account account) {
		accountService.add(account);
		return "redirect:/index";
	}
}
