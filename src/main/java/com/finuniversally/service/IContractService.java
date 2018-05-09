package com.finuniversally.service;

import com.finuniversally.model.Contract;

import java.util.List;

/**
 * Created by may on 2018/5/7.
 */
public interface IContractService {
    /**
     * 添加合约信息
     *@Author: May
     *@param
     *@Date: 11:53 2018/5/7
     */
    void save(Contract contract);
    /**
     * 修改合约信息
     *@Author: May
     *@param
     *@Date: 11:54 2018/5/7
     */
    void update(Contract contract);
    /**
     * 获取合约信息列表
     *@Author: May
     *@param
     *@Date: 13:43 2018/5/7
     */
    List<Contract> getListByContract();
}
