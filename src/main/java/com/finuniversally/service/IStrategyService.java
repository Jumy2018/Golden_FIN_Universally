package com.finuniversally.service;

import com.finuniversally.model.Strategy;
import com.finuniversally.vo.StrategyVO;

import java.util.List;

/**
 * Created by may on 2018/5/7.
 */
public interface IStrategyService {
    /**添加策略
     *@Author: May
     *@param
     *@Date: 13:44 2018/5/7
     */
    void save(Strategy strategy);
    /**编辑策略
     *@Author: May
     *@param
     *@Date: 13:45 2018/5/7
     */
    void update(Strategy strategy);
    /**
     * 返回页面策略数据
     *@Author: May
     *@param
     *@Date: 13:46 2018/5/7
     */
    List<StrategyVO> getListStrategyVO();

}
