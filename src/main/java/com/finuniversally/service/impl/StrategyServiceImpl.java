package com.finuniversally.service.impl;

import com.finuniversally.model.DocumentaryDetailedData;
import com.finuniversally.model.Strategy;
import com.finuniversally.service.IStrategyService;
import com.finuniversally.untils.CustomerGenerateUtils;
import com.finuniversally.vo.CustomerDataVO;
import com.finuniversally.vo.StrategyVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by may on 2018/5/7.
 */
@Service
public class StrategyServiceImpl implements IStrategyService {
    private List<Strategy> strategies = CustomerGenerateUtils.getAllStrategies();
    private static Long count = 2L;
    @Override
    public void save(Strategy strategy) {
        strategy.setId(count);
        count++;
        strategies.add(strategy);
    }

    @Override
    public void update(Strategy strategy) {
        for (Strategy strategy1 : strategies) {
            if(strategy1.getId().equals(strategy1.getId())){
                strategy1=strategy;
            }
        }

    }

    @Override
    public List<StrategyVO> getListStrategyVO() {
        List<StrategyVO> strategyVoList = new ArrayList<>();
        for (Strategy strategy : strategies) {
            StrategyVO strategyVO = new StrategyVO();
            strategyVO.setStrategy(strategy);
            StringBuilder sBuilder = new StringBuilder(100);
            sBuilder.append(strategy.getAccount().getUsername()).append(strategy.getVariety().getVarietyCode()).
                    append(strategy.getCustomerPlatform().getName());
            //客户数据
            Map<String, List<CustomerDataVO>> customerDataVOs = CustomerGenerateUtils.getCustomerDataVOs();
            List<CustomerDataVO> customerDataVOList = customerDataVOs.get(sBuilder.toString());
            Double customerGainAndLoss = 0.0;
            for (CustomerDataVO customerDataVO : customerDataVOList) {
                customerGainAndLoss+=customerDataVO.getCustomerSurplus();
            }

            strategyVO.setCustomerGainAndLoss(customerGainAndLoss);//客户盈亏
            //跟单成功率
            int successCount=0;
            int sum=0;
            Map<String, List<DocumentaryDetailedData>> detailedDatas = CustomerGenerateUtils.getDetailedDatas();
            List<DocumentaryDetailedData> documentaryDetailedData = detailedDatas.get(sBuilder.toString());
            for (DocumentaryDetailedData detailedData : documentaryDetailedData) {
                sum++;
                if(detailedData.getStatus()!=null&&detailedData.getStatus().equals(DocumentaryDetailedData.DETAILED_STATUS_YES)){
                    successCount++;
                }
            }
            strategyVO.setSuccessRatio(successCount + "/" +sum);//跟单成功率
            strategyVO.setOpsitionGainAndLoss(3559.8);//持仓盈亏
            strategyVO.setOffsetGainAndLoss(1227.7);//平仓盈亏
            strategyVO.setPoundage(new BigDecimal("123"));
            strategyVoList.add(strategyVO);
        }

        return strategyVoList;
    }


}
