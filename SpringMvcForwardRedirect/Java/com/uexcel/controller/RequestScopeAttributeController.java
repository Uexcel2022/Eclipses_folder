package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RequestScopeAttributeController {

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/requestAttributeForwarded")
	public String GetRequestAttributePage2(Model model, HttpServletRequest request) {
		request.setAttribute("firstName", "Uexcel");
		model.addAttribute("language", "English");    
		return "forward:/display";
	}
	
	@GetMapping("/requestAttributeRedirected")
	public String GetRequestAttributePage(Model model, HttpServletRequest request) {
		request.setAttribute("firstName", "Uexcel");
		model.addAttribute("language", "English");    
		return "redirect:/display";
		 //when you redirect  value set in request scope won't be available at the destination
		// because redirect result in the browser making a fresh request
	}
	
	@GetMapping("/display")
	public String displayRequestAttribute() {
		return "requestAttribute";
	}
}

