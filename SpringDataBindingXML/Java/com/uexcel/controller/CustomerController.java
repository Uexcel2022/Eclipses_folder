package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uexcel.model.Customer;

@Controller
@RequestMapping(value= {"/", "/customer"})
public class CustomerController {
	
	@GetMapping("/")
	public String getWelcomePage() {
		return"welcome";
	}
	@GetMapping("/customersignupform")
	public String getCustomerForm() {
		return"customersignupform";
	}
	@PostMapping("/saveinfo")
	public String saveCustomerInfo(Customer customer) {
		return"customerdetails";
	}
	
	
	
	
	

}
