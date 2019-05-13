package com.zzg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/validate")
	public String validate(){
		return "validate";
	}
	
	@RequestMapping("/widget")
	public String widget(){
		return "widget";
	}
}
