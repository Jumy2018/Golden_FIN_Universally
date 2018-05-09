package com.finuniversally.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户的交易数据
 * @author may
 *
 */
@AllArgsConstructor@NoArgsConstructor
public class CustomerTradeDate implements Serializable {
    private Long id;
    //开仓价格
    private BigDecimal openPrice;
    //开仓时间
    private Date openTime;
    //平仓价格
    private BigDecimal closePrice;
    //平仓时间
    private Date closeTime;
    //手续费
    private BigDecimal poundage;
    //跟单数
    private Integer documentaryNum;
    //失败的跟单数
    private Integer failureNum;
    //策略
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public BigDecimal getPoundage() {
        return poundage;
    }

    public void setPoundage(BigDecimal poundage) {
        this.poundage = poundage;
    }

    public Integer getDocumentaryNum() {
        return documentaryNum;
    }

    public void setDocumentaryNum(Integer documentaryNum) {
        this.documentaryNum = documentaryNum;
    }

    public Integer getFailureNum() {
        return failureNum;
    }

    public void setFailureNum(Integer failureNum) {
        this.failureNum = failureNum;
    }
}
