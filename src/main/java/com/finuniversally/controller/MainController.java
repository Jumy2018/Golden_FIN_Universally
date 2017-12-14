package com.finuniversally.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finuniversally.model.Variety;
import com.finuniversally.service.VarietyService;

@Controller
public class MainController {
	//日志
	private static final Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private VarietyService varietyService;
	
	@RequestMapping(value={"/"},method={RequestMethod.GET})
	public String head() {
		List<Variety> varietys = varietyService.getVarietys();
		for(Variety variety: varietys) {
			System.out.println(variety.getVarietyName());
		}
		return "index";
	}
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model) throws Exception{
		return "index";
	}
}
