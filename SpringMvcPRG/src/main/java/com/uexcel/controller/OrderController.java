package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uexcel.model.Order;


@Controller
public class OrderController {

	@GetMapping("/")
	public String getOderForm(@ModelAttribute("order") Order order) {
		return "orderForm";
	}
     
	//Flush attribute is is used to send object to the destination page when using redirect and it's automatically removed 
	// from the session scope  after the page is rendered
	
	@PostMapping("/saveOrder")
	public String saveOrder(Order order,  RedirectAttributes redirect) {
		redirect.addFlashAttribute("OrderDetails",order);
		return"redirect:success";
	}
	
	@GetMapping("/success")
	public String message() {
		return "thanks";
	}
}
