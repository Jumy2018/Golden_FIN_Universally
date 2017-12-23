package com.finuniversally.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finuniversally.model.Account;
import com.finuniversally.model.User;

/**
 * 账号相关业务
 * @author riseSun
 *
 * 2017年12月23日下午3:47:59
 */
public interface AccountService {
	/**
	 * 添加账号
	 * @param account
	 * @return
	 * @author riseSun
	
	 * 2017年12月23日下午3:48:44
	 */
	public Account add(Account account);
	
	/**
	 * 获取所有账户
	 * @return
	 * @author riseSun
	
	 * 2017年12月23日下午5:52:21
	 */
	public List<Account> getAllAccounts();
}
