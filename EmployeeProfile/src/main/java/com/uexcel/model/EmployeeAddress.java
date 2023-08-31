package com.uexcel.model;

public class EmployeeAddress {
    private String street;
    private String state;
    private String city;
    
    
	public EmployeeAddress(String street, String city, String state) {
		this.street = street;
		this.state = state;
		this.city = city;
	}
	
	
	public String getStreet() {
		return street;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}

	
    
}