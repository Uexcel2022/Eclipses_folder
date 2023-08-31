package com.uexcel.model;

public class FetchData {
private String firstName;
private String lastName;
private String gender;
private String phone;
private String error;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
@Override
public String toString() {
	return "FetchData [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", phone=" + phone
			+ ", error=" + error + "]";
}





}
