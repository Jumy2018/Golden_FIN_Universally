package com.finuniversally.controller;

import com.finuniversally.service.IStrategyService;
import com.finuniversally.untils.WebJsion;
import com.finuniversally.vo.StrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by may on 2018/5/7.
 */
@Controller
public class StrategyController {
    @Autowired
    private IStrategyService strategyService;

    @RequestMapping("/getListStrategyVo")
    @ResponseBody
    public String getListStrategyVo(){
        WebJsion jsion = new WebJsion();
        List<StrategyVO> listStrategyVO = strategyService.getListStrategyVO();
        return jsion.toJson(listStrategyVO);
    }
}
