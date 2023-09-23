package com.uexcel.domain;



import jakarta.validation.constraints.Pattern;

public class Address {

	
	@Pattern(regexp = "([A-Za-z0-9-]\\s*)+",message = "The filed is empty or the value is invaid!")
	private String street;
	
	@Pattern(regexp = "[A-Za-z0-9-]+", message = "The filed is empty or the value is invaid!")
	private String state;
     
	@Pattern(regexp = "[0-9][0-9][0-9][0-9]*", message = "The filed is empty or the value is invalid!")
	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
