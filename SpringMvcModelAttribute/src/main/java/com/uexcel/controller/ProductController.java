package com.uexcel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uexcel.model.Category;
import com.uexcel.model.Product;

@Controller
@RequestMapping(value = { "/" })
public class ProductController {

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/details")
	public String getProductDetails(@ModelAttribute("prod") Product product, Model model) {
		System.out.println(model.asMap().get("categoryList"));
		return "showproduct";
	}

	@ModelAttribute("categoryList") // information in this method can be retrieved in every method in the class from Model object.
	public List<Category> getCategoryList() {
		return Arrays.asList(new Category(1, "Computer"), new Category(2, "Mobile Phone"));

	}
}
