package com.finuniversally.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.finuniversally.controller.AccountVo;
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
	public void add(String userName,String passWord,Long platFormId);
	/**
	 * 获取所有交易账号
	 * @return
	 * @author riseSun
	
	 * 2017年12月23日下午10:28:34
	 */
	@Select("select t2.id,t2.USER_NAME as username,t2.PASS_WORD as password,(select t.PLATFORM_NAME as name from GFU_TRADE_PLATFORM t where t.id=t2.TRADE_PLATFORM) as platformName,t2.TRADE_PLATFORM as platformId  from GFU_ACCOUNT t2")
	public List<AccountVo> getAllAccounts();
}
