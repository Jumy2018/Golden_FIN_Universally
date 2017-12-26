package com.finuniversally.mapper;

import java.util.List;

import com.finuniversally.model.Account;

public interface AccountMapper {
	/**
	 * 保存交易账户
	 * @param account
	 * @author riseSun
	
	 * 2017年12月25日下午11:13:19
	 */
	public void saveAccount(Account account);
	/**
	 * 获取所有交易账户
	 * 
	 * @author riseSun
	
	 * 2017年12月25日下午11:13:26
	 */
	public List<Account> getAccounts();
	/**
	 * 根据ID获取交易账户
	 * @return
	 * @author riseSun
	
	 * 2017年12月25日下午11:17:54
	 */
	public Account getAccountById(Long accountId);
	/**
	 * 修改交易账户信息
	 * @param account
	 * @author riseSun
	
	 * 2017年12月25日下午11:18:27
	 */
	public void updateAccount(Account account);
	/**
	 * 删除交易账户
	 * @param account
	 * @author riseSun
	
	 * 2017年12月25日下午11:19:05
	 */
	public void delAccount(Account account);
	
}

