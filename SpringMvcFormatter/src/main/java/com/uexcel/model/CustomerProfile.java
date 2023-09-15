package com.uexcel.model;

public class CustomerProfile {
	private String firstName;
	private String lastName;
	private Phone phone;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CustomerProfile [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
	
	
	
	
}
