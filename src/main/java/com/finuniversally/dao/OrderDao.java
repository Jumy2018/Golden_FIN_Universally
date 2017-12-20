package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
	@Select("select count(*) from orders75 t where t.cmd=#{cmd};")
	public Double getHoldQtys(Long cmd);
}
