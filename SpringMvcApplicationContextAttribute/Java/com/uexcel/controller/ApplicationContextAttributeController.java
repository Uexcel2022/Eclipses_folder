package com.uexcel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletContext;

@Controller

public class ApplicationContextAttributeController {
	
	@Autowired
	ServletContext  serveletContext;
	
	@GetMapping("/")
	public String getIndexpage() {
		return"index";
	}
	
	@GetMapping("/appContextAttribute")
	public String setAppContextAttribute() {
		serveletContext.setAttribute("application", "Application context attribute");
		return "redirect:/display";
	}
	
	@GetMapping("/display")
	public String getDisplayPage() {
		return"display";
	}
	
	@GetMapping("/test")
	public String getTestPage() {
		return"test";
	}

}
