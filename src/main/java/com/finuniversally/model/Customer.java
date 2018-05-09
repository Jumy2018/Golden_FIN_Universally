package com.finuniversally.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 客户实体
 * @author may
 *
 */
@NoArgsConstructor@AllArgsConstructor
public class Customer implements Serializable {
    private Long id;
    //客户的账号
    private String login;
    //客户的跟单数据(应该是一对多的),TODO
    private List<CustomerDocumentaryParameters> customerDocumentaryParameters;
    //策略的id应该是多对多的关系 ,通过key值找到对应的策略(数据传输也只是找到品种,数据源,交易账号是没有的) 先假设只有一个 TODO
   private List<Strategy> strategies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public List<CustomerDocumentaryParameters> getCustomerDocumentaryParameters() {
        return customerDocumentaryParameters;
    }

    public void setCustomerDocumentaryParameters(List<CustomerDocumentaryParameters> customerDocumentaryParameters) {
        this.customerDocumentaryParameters = customerDocumentaryParameters;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }
}
