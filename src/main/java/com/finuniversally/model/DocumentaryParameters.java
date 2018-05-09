package com.finuniversally.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 平台跟单参数
 * @author may
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class DocumentaryParameters implements Serializable {
    public static final int ORDERPOINT_NO = 0;//限价
    public static final int ORDERPOINT_YES = 1;//市价
    public static final Boolean STRATEGY_TYPE_NO = false;//反向跟单
    public static final Boolean STRATEGY_TYPE_YES = true;//正向跟单
    private Long id;
    //跟单类型[正/反],真为正向跟单
    private Boolean type;
    //净头寸变化,
    private Integer changeNum;
    //跟多少手
    private Integer followNum;
    //下单点位 1:市价，0表示：限价
    private Integer orderPoint;
    //下单点位：比客户好
    private Boolean customerPoint;
    //下单点位：点数
    private Double customerPointNum;
    //最大止盈
    private Integer bigCheckSurplus;
    //最大止损
    private Integer bigStopLoss;
    //账户止损
    private Integer accountStopLoss;
    //当前净头寸的值
    private Double headNum;
    //应持仓的值
    private Integer holdNum;
}