package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
	
	@Select("select sum(qty) from ${arg0} t where symbol=#{arg1} and t.cmd=#{arg2,jdbcType=INTEGER} ")
	public Double getHoldQtys(String table,String variety,Long cmd);
	

}
