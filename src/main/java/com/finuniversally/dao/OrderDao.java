package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
	
	@Select("select sum(qty) from orders75 t where t.cmd=0 and symbol=#{arg0}")
	public Double getHoldQtys75(String variety,Long cmd);

	@Select("select sum(qty) from orders76 t where t.cmd=0 and symbol=#{arg0}")
	public Double getHoldQtys76(String variety,Long cmd);

}
