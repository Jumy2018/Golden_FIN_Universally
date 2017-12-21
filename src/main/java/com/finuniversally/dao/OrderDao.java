package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
	
	//获取持仓手数
	@Select("select sum(qty) from ${arg0} t where t.symbol=#{arg1} and t.cmd=#{arg2,jdbcType=INTEGER} and t.close_time is null")
	public Double getHoldQtys(String table,String variety,Long cmd);
	
	//获取总价(持仓手数*开仓价格)
	@Select("select sum(t.qty*t.) from ${arg0} t where t.symbol=#{arg1} and t.cmd=#{arg2,jdbcType=INTEGER} and t.close_time is null")
	public Double getTotalPrice(String table,String variety,Long cmd);
	
	
}
