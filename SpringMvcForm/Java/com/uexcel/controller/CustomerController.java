package com.uexcel.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uexcel.model.Country;
import com.uexcel.model.Customer;
import com.uexcel.model.Phone;

@Controller
@RequestMapping(value= {"/"})
public class CustomerController {

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/form")
	public String getCustomerSignupForm(@ModelAttribute("customer") Customer customer, Model model) {
       
		List<Country> countriesObjList = getCountries();
				
		model.addAttribute("countriesObjList",countriesObjList);
		
		return"customerSignupForm";
	}
	
	@PostMapping("/submitform")
	public String SubmitForm(@ModelAttribute("customer") Customer customer) {
		return"custmerDetails";
	}
	
	@GetMapping("/editcustomer")
	public String editcustomer(Model model) {
		Phone phone = new Phone("123","344","2738");
		Customer customer = new Customer();
		customer.setFirstName("Zera");
		customer.setLastName("Kelven");
		customer.setPhone(phone);
	
		List<Country> countriesObjList = getCountries();
		
		model.addAttribute("countriesObjList",countriesObjList);
		model.addAttribute("customer",customer);
		return "customerSignupForm";
		
	}
	
	public List<Country> getCountries(){
		
		//String form select tags
		//1 List
//		List<String> countriesList = Arrays.asList("United States", "Nigeria", "China", "Russia");
//		model.addAttribute("countriesList", countriesList );
		// 2 Map
//		Map<String, String> countriesMap = new HashMap<>();
//		countriesMap.put("US", "United States");
//		countriesMap.put("UK", "United Kingdom");
//		countriesMap.put("Ng", "Nigeria");
//		countriesMap.put("CN", "China");
//		model.addAttribute("countriesMap", countriesMap);
//		String[] list = {"United State","Russia", "China", "Nigeria"};
//		
//		Set<String> countriesList = new TreeSet<>();
//		for(String n: list ) {
//			countriesList.add(n);
//		}
//		countriesList.add("United State");
//		countriesList.add("Russia");
//		countriesList.add("China");
//		countriesList.add("Nigeria");
//		model.addAttribute("countriesList", countriesList);
		
		List<Country> countriesObjList = Arrays.asList(new Country("US","United State"), new Country("UK","United Kingdom"),
				new Country("RS","Russia"),new Country("CN","China"),new Country("NG","Nigeria"));
		
		return countriesObjList;
		
	}
	
}
