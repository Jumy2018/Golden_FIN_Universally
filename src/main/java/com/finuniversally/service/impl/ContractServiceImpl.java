package com.finuniversally.service.impl;

import com.finuniversally.cache.DataCache;
import com.finuniversally.model.Contract;
import com.finuniversally.service.IContractService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by may on 2018/5/7.
 */
@Service
public class ContractServiceImpl implements IContractService {
    private List<Contract> contractList = DataCache.getInstance().getContractList();
    private static Long count =1L;

    @Override
    public void save(Contract contract) {
        contract.setId(count);
        contractList.add(contract);
        count++;
    }

    @Override
    public void update(Contract contract) {
        for (Contract contract1 : contractList) {
            if(contract.getId().equals(contract1.getId())){
                contract1 = contract;
            }
        }
    }

    @Override
    public List<Contract> getListByContract() {
        return contractList;
    }
}
