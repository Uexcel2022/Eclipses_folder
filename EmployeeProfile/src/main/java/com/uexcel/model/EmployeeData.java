package com.uexcel.model;

public class EmployeeData {
    private Integer empID;
    private String firstName;
    private String lastName;
    private EmployeeAddress address;
    
    
	public EmployeeData(Integer empID, String firstName, String lastName) {
		
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public EmployeeData() {
		
	}
	
	public Integer getEmpID() {
		return empID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public EmployeeAddress getAddress() {
		return address;
	}

	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}
    
	
    
}
