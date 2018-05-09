package com.finuniversally.vo;

import com.finuniversally.model.Strategy;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 页面展示数据
 * Created by may on 2018/5/7.
 */
@Getter@Setter
public class StrategyVO {
    private Strategy strategy;
    private Double opsitionGainAndLoss;// 持仓盈亏
    private Double offsetGainAndLoss;//平仓盈亏
    private BigDecimal poundage; //手续费
    private Double gainAndLossRatio;//盈亏效率=平仓盈亏/手续费
    private Double CustomerGainAndLoss;//客户盈亏
    private String successRatio;//跟单成功率

    public Double getGainAndLossRatio() {
       BigDecimal offset = new BigDecimal(offsetGainAndLoss);
        return  offset.divide(this.poundage,2, RoundingMode.HALF_UP).doubleValue();
    }


}
