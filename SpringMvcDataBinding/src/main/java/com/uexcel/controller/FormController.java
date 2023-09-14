package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.UserModel;


@Controller
@RequestMapping(value={"/", "user",})
public class FormController {

	@GetMapping({"/","signupform"})
	public String getForm() {
		return "signupform";
	}
	@PostMapping("/signup")
	public String submitForm(UserModel user) {
		System.out.println(user);
		return "response";
	}
}
