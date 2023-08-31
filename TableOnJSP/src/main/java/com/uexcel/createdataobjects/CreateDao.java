package com.uexcel.createdataobjects;

public class CreateDao {
   private String firstName;
   private  String lastName;
   private String gender;
   private String phone;
   
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
@Override
public String toString() {
	return "CreateDao [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", phone=" + phone
			+ "]";
}
   
   
   
   
   
}
