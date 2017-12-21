package com.finuniversally.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
	
	//获取持仓手数
	@Select("select sum(qty) from ${arg0} t where t.symbol=#{arg1} and t.cmd=#{arg2,jdbcType=INTEGER} and t.close_time is null")
	public Double getHoldQtys(String table,String variety,Long cmd);
	
	//获取一小时头寸
	@Select("SELECT " + 
			"    (SELECT " + 
			"            SUM(t.qty)" + 
			"        FROM" + 
			"            ${table} t" + 
			"        WHERE" + 
			"            t.cmd = 0 AND t.symbol = '#{variety}'" + 
			"                AND t.close_time IS NULL" + 
			"                AND t.open_time > DATE_SUB(NOW(), INTERVAL 1 HOUR)) - (SELECT " + 
			"            SUM(t.qty)" + 
			"        FROM" + 
			"            ${table} t" + 
			"        WHERE" + 
			"            t.cmd = 1 AND t.symbol = '#{variety}'" + 
			"                AND t.close_time IS NULL" + 
			"                AND t.open_time > DATE_SUB(NOW(), INTERVAL 1 HOUR)) AS netPosition" + 
			"FROM DUAL")
	public Double getNetPositionHourly(String table,String variety);

	//获取总价(持仓手数*开仓价格)
	@Select("select sum(t.qty*t.) from ${arg0} t where t.symbol=#{arg1} and t.cmd=#{arg2,jdbcType=INTEGER} and t.close_time is null")
	public Double getTotalPrice(String table,String variety,Long cmd);
	
	//获取市价
	@Select("select ${arg0} from prices where symbol=#{arg1};")
	public Double getMarketPrice(String type,String variety);
	
	//平仓盈亏
	@Select("select sum(profit) from ${arg0} where symbol=#{arg1} and close_time is not null")
	public Double getOffsetGainAndLoss(String table,String variety);
	
}
