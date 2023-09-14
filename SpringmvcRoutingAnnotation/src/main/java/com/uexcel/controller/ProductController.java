package com.uexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"/product"})
public class ProductController {
	
	@GetMapping("/productlist")
//	product/productlist?categoryid=1&categoryname=laptop 
//	product/productlist?categoryid=1 
//	Resolving providing for just one parameter.
//	@RequestParam Integer/String categoryid
	
	public String getProductByCategory(@RequestParam Integer categoryid, 
			@RequestParam(value = "categoryname", required = false, defaultValue = "computer") String name) {
		
		System.out.println("CategoryId: " + categoryid  +" Category name: " +name);
		
		return "result";
	}
	
	//part variable annotation
	// "/product/categoryId/33/categoryName=ipad"
	
	@GetMapping("categoryId/{categoryId}/categoryName={categoryName}")
     public String getPathVariable(@PathVariable Integer categoryId, @PathVariable ("categoryName") String name) {
		System.out.println("CategoryId: " + categoryId  +" Category name: " +name);
		
		return "result";
     }
} 
