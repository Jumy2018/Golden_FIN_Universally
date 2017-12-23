package com.finuniversally.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.finuniversally.dynasqlprovider.AccountDynaSqlProvider;
import com.finuniversally.model.Account;
import com.finuniversally.model.User;

public interface AccountDao {
	/**
	 * 添加交易账号
	 * @param account
	 * @return
	 * @author riseSun
	
	 * 2017年12月23日下午10:28:23
	 */
	@Insert("insert into GFU_ACCOUNT(USER_NAME,PASS_WORD,TRADE_PLATFORM) "
			+ "values(#{arg0},#{arg1},#{arg2,jdbcType=INTEGER})")
	public Account add(String userName,String passWord,Long platFormId);
	/**
	 * 获取所有交易账号
	 * @return
	 * @author riseSun
	
	 * 2017年12月23日下午10:28:34
	 */
	@Select("select * from account")
	public List<Account> getAllAccounts();
}
