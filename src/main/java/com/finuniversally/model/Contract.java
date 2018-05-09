package com.finuniversally.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by may on 2018/5/7.
 */
@Getter@Setter
public class Contract implements Serializable {
    private Long id;
    private Long VarietyId;//品种id
    private String name;//合约名称
    private String stewardContractCode;//信管家
    private String spContractCode;//sp合约代码
    private String bigContractCode;//大有合约代码
}
