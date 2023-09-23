package com.uexcel.domain;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class User {

	@Pattern(regexp = "([A-Za-z]\\s*){2,30}", message = "The filed is empty or the value is invaid!")
	private String username;

	@Email(regexp = "[a-z0-9]+[_.]?[a-z0-9]+[._]?[a-z0-9]+@[a-z0-9]+[a-z.]*\\.[a-z]{2,3}", message = "The filed is empty or not valid email")
	private String email;

	@Pattern(regexp = "([1][8-9])|([2-9][0-9])|([1][0-2][0-9]+)", message = "Age must be digit; range: 18 - 129 years ")
	private String age;

	@NotNull(message = "Birthday is required field. format:yyyy-mm-dd")
	private String birthday;

	@NotEmpty(message = "Role must have a value")
	private String role;

	@Valid
	private Address addr;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		String[] date = birthday.split("-");
		if (date.length == 3 && date[0].length() == 4) {
			try {
				int year = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int day = Integer.parseInt(date[2]);
				String b = (String) LocalDate.of(year, month, day).toString();
				this.birthday = b;
				return;
			} catch (Exception e) {
				this.birthday = null;
			}
		}
		this.birthday = null;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public void verifyDate() {

	}

}
