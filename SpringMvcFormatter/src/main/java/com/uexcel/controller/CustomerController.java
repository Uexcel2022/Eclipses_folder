package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uexcel.model.CustomerProfile;



@Controller
@RequestMapping(value = { "/", "customer" })
public class CustomerController {

	@GetMapping("/")
	public String getCustomerForm() {
		return "customerform";
	}

	@PostMapping("/savecustomer")
	public String saveCustomer(CustomerProfile customer, @ModelAttribute("customer") CustomerProfile ct ) {
		return "customerdetails";
	}

}
