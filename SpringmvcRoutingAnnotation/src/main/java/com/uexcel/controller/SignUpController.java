package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/" ,"signup", "resend"})
public class SignUpController {
	
	@GetMapping("/")
	public String getWelcome() {
		return"welcome";
	}
	
	@GetMapping("/signup")
	public String getSignUpform() {
		return"signupform";
	}
	
	@PostMapping("/signup")
	public String getresult() {
		return"result";
	}
}
