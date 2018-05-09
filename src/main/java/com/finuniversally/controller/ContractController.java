package com.finuniversally.controller;

import com.finuniversally.model.Contract;
import com.finuniversally.service.IContractService;
import com.finuniversally.untils.JSONResult;
import com.finuniversally.untils.WebJsion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by may on 2018/5/7.
 */
@Controller
public class ContractController {
    @Autowired
    private IContractService contractServiceImpl;
    /**
     * 合约信息添加
     *@Author: May
     *@param
     *@Date: 11:48 2018/5/7
     */
    @RequestMapping("/addContract")
    @ResponseBody
    public JSONResult addContract(Contract contract){
        JSONResult result = null;
        try{
            contractServiceImpl.save(contract);
            result = new JSONResult("保存成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new JSONResult(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping("/updateContract")
    @ResponseBody
    public JSONResult updateContract(Contract contract){
        JSONResult result = null;
        try{
            contractServiceImpl.update(contract);
            result = new JSONResult("编辑成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new JSONResult(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getListByContract")
    @ResponseBody
    public String getListByContract(){
        WebJsion json = new WebJsion();
        List<Contract> listByContract = contractServiceImpl.getListByContract();
        return json.toJson(listByContract);
    }
}
