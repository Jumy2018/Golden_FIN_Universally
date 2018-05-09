package com.finuniversally.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 客户跟单参数
 * @author may
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDocumentaryParameters implements Serializable {
   public static final int HANDTYPE_NO=0;//按固定的手数
   public static final int HANDTYPE_YES=1;//按比例

    private Long id;
    //跟单类型[正/反],真为正
    private Boolean type;
    //手数类型[按比例/固定],真为按比例
    private Integer handType;
    //手数,固定的手数
    private Double handNum;
    //按比例
    private Double ratioHandNum;
    //策略id
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getHandType() {
        return handType;
    }

    public void setHandType(Integer handType) {
        this.handType = handType;
    }

    public Double getHandNum() {
        return handNum;
    }

    public void setHandNum(Double handNum) {
        this.handNum = handNum;
    }

    public Double getRatioHandNum() {
        return ratioHandNum;
    }

    public void setRatioHandNum(Double ratioHandNum) {
        this.ratioHandNum = ratioHandNum;
    }
}
