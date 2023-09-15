package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uexcel.model.Customer;

@Controller
@RequestMapping(value= {"/"})
public class CustomerController {

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/form")
	public String getCustomerSignupForm(@ModelAttribute("customer") Customer customer) {
		return"customerSignupForm";
	}
	@PostMapping("/submitform")
	public String SubmitForm(@ModelAttribute("customer") Customer customer) {
		return"custmerDetails";
	}
}
