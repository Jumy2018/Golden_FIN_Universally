package com.finuniversally.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finuniversally.dao.AccountDao;
import com.finuniversally.model.Account;
import com.finuniversally.model.User;
import com.finuniversally.service.AccountService;

/**
 * 交易账户相关业务
 * @author riseSun
 *
 * 2017年12月23日下午10:26:30
 */
@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Account add(Account account) {
		return accountDao.add(account.getUsername(),account.getPassword(),account.getPlatform().getId());
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}
	
}
