package com.finuniversally.vo;

import com.finuniversally.model.Strategy;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * 策略的客户数据
 *@Author: May
 *@param
 *@Date: 10:24 2018/5/9
 */
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class CustomerDataVO implements Serializable {
    public static final int STATUS_NO=0;//未跟单
    public static final int STATUS_YES=1;//已跟单
    private Long id;
    //账号
    private String login;
    //和TCP数据一样，开仓单号，唯一标识
    private String openOrderNum;
    //品种
    private String varietyCode;
    //类型 0是买入，1是卖出
    private Integer cmd;
    //手数
    private Double handNum;
    //开仓价
    private Double openPrice;
    //开仓时间
    private Date openTime;
    //平仓价
    private Double closePrice;
    //平仓时间
    private Date closeTime;
    //手续费
    private Double poundage;
    //客户盈亏
    private Double customerSurplus;
    //是否已跟单
    private Integer status;
    //策略
    private Strategy strategy;


}
