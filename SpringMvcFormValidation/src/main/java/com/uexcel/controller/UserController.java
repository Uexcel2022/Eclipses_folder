package com.uexcel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uexcel.domain.User;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@ModelAttribute
	private void populateRole(Model model){
		Map<String, String>roleMap = new HashMap<>();
		roleMap.put("Admin", "Admin");
		roleMap.put("DBA", "DBA");
		model.addAttribute("roles",roleMap);
	}
	
	@GetMapping("/add")
	public String getUserForm(@ModelAttribute("user") User user, Model model) {
		return "userForm";
	}
	
	@PostMapping("/add")
	public String submit(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirct) {
		if(result.hasErrors()) {
			return "userForm";
		}
		redirct.addFlashAttribute("user", user);
		return "redirect:/user/Details";
	}
	
	@GetMapping("/Details")
	public String showUserDetails() {
		return "success";
	}
	
}
