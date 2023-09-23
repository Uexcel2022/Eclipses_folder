package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/")
@SessionAttributes({"name"})
public class SessionScopeAttributeController {

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/session")
	public String setSessionAttribute(Model model, HttpSession  session) {
		
	  model.addAttribute("name", "Daniel"); // this is added just before the page rendering b4 the current request ends
	  session.setAttribute("lang", "English"); // this is added to session scope immediately
	  
	  return "redirect:/display";
  }

	@GetMapping("/display")
	public String displaySessionAttribute(SessionStatus session) {
		session.setComplete();  
		//This can only remove session attributes set with @SessionAttribute annotation on springmvc and it removes all the session 
	       //scope attributes after the page rendering
		return "display";

	}
}
