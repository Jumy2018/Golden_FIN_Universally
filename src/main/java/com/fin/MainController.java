package com.fin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private static final Logger log = Logger.getLogger(MainController.class.getName());
	@RequestMapping(value={"/"},method={RequestMethod.GET})
	public String head() {
		log.info("集成这个日志废了我很长时间，配置文件中，不仅保存在文件夹中，还实时打印在控制台。");
		return "index";
	}
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model) throws Exception{
		model.addAttribute("msg","金证通跟单管理系统!");
		return "index";
	}
}
