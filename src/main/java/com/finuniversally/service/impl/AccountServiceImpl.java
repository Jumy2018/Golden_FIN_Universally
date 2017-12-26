package com.finuniversally.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finuniversally.mapper.AccountMapper;
import com.finuniversally.model.Account;
import com.finuniversally.model.AccountVo;
import com.finuniversally.model.User;
import com.finuniversally.service.AccountService;

/**
 * 交易账户相关业务
 * @author riseSun
 *
 * 2017年12月23日下午10:26:30
 */
@Component
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public void add(Account account) {
		Long accId = null;
		if((accId = account.getId()) == null) {
			accountMapper.saveAccount(account);
		}else {
			if(accountMapper.getAccountById(accId) == null) {
				return;
			}else {
				accountMapper.updateAccount(account);
			}
		}
	}

	@Override
	public List<AccountVo> getAllAccounts() {
		List<AccountVo> accountVos = new ArrayList<AccountVo>();
		List<Account> accounts = accountMapper.getAccounts();
		for(Account account : accounts) {
			AccountVo accountVo = new AccountVo();
			accountVo.setId(account.getId().longValue()+"");
			accountVo.setPlatformId(account.getPlatform().getId().longValue()+"");
			accountVo.setPlatformName(account.getPlatform().getName());
			accountVo.setUsername(account.getUsername());
			accountVo.setPassword(account.getPassword());
			accountVos.add(accountVo);
		}
		return accountVos;
	}

	@Override
	public void del(Account account) {
		accountMapper.delAccount(account);
	}
	
}
