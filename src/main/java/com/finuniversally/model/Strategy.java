package com.finuniversally.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 平台策略
 * 2017年12月23日上午1:11:29
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Strategy implements Serializable {

    public static final int STRATEGY_STATUS_YES=1;//策略启动
    public static final int STRATEGY_STATUS_NO=0;//策略不启动

    private Long id;
    //数据源平台
    private CustomerPlatform customerPlatform;
    //品种
    private Variety variety;
    //交易账号
    private Account account;
    //平台跟单参数
    private DocumentaryParameters documentaryParameters;
    //客户
    private List<Customer> customers;
    //是否启用
    private Integer status;
    //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openTime;
    //时间戳
    private Long updateTime;


}
