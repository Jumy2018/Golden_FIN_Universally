package com.finuniversally.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by may on 2018/4/23.
 * 跟单明细数据
 */
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class DocumentaryDetailedData {
    public static final int DETAILED_STATUS_NO=0;//跟单失败
    public static final int DETAILED_STATUS_YES=1;//跟单成功
    private Long id;
    //用户名or净头寸
    private String login;

    //和TCP数据一样，开仓单号，唯一标识,通过这个唯一标识知道是哪个客户数据
    private String openOrderNum;
    //交易单号
    private String tradeNum;
    //多空(0=多,1=空),类型
    private Integer cmd;
    //手数
    private Double counts;
    //开仓价格
    private Double openPrice;
    //开仓时间
    private Date openTime;
    //平仓价格
    private Double closePrice;
    //平仓时间
    private Date closeTime;
    //手续费
    private BigDecimal poundage;
    //跟单是否成功
    private Integer status;
    //策略的id,品种从策略里面取出,后期数据库进行关联
    private Strategy strategy;
    //剩余的手数
    private Double leftoverCounts;
    //已经平仓过的盈亏,要等交易系统把价格传过来才知道
    private BigDecimal alreadyProfit;

}
