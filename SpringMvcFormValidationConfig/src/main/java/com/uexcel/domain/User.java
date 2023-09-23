package com.uexcel.domain;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;

public class User {

	private String isValidAge;
	private LocalDate localDate;
	private String stringDate;

	@Null(message = "Please enter a valid date!!!")
	private String invalidDate;

	@Null(message = "Age and birthday did not match!!!")
	private String checkAge;

	@Null(message = "Age must be between 18 - 120 years!!!")
	private String checkBirthday;

	@Pattern(regexp = "([A-Za-z]\\s*){2,30}", message = "Please enter a valid  name.")
	private String username;

	@Email(regexp = "[a-z0-9]+[_.]?[a-z0-9]+[._]?[a-z0-9]+@[a-z0-9]+[a-z.]*\\.[a-z]{2,3}", message = "Please enter a valid email address.")
	private String email;

	@NotEmpty(message = "Age is a required fields!!!")
	private String age;

	@NotEmpty(message = "Birthday is a required fields!!!")
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
		if (age.isEmpty()) {
			this.age = age;
			return;
		}

		isValidAge = age;
	}

	public String getBirthday() {

		return birthday;
	}

	public void setBirthday(String birthday) {

		if (birthday.isEmpty()) {
			this.birthday = birthday;
			validateAge(null);
			return;
		}

		try {
			String[] date = birthday.split("-");
			if (date.length == 3 && date[0].length() == 4) {
				int year = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int day = Integer.parseInt(date[2]);
				stringDate = (String) LocalDate.of(year, month, day).toString();
				this.localDate = LocalDate.of(year, month, day);
				validateAge(null);
				return;
			}

			if (date.length == 3 && date[2].length() == 4) {
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);
				stringDate = (String) LocalDate.of(year, month, day).toString();
				this.localDate = LocalDate.of(year, month, day);
				validateAge(null);
				return;
			}

		} catch (Exception e) {
			this.invalidDate = "true";
			validateAge(birthday);
			return;
		}

		this.birthday = birthday;
		this.invalidDate = "ok";
		validateAge(birthday);

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

	public String getCheckAge() {
		return checkAge;
	}

	public void setCheckAge(String checkAge) {
		this.checkAge = checkAge;
	}

	public String getCheckBirthday() {
		return checkBirthday;
	}

	public void setCheckBirthday(String checkBirthday) {

		this.checkBirthday = checkBirthday;
	}

	public String getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(String indvalidDate) {
		this.invalidDate = indvalidDate;
	}

	private void validateAge(String date) {

		if ((isValidAge == null || stringDate == null) && date == null) {
			this.age = isValidAge;
			this.birthday = stringDate;
			return;
		}

		if (date != null) {
			this.birthday = date;
			this.age = isValidAge;
			return;
		}

		try {

			if (Integer.parseInt(isValidAge) < 18 || Integer.parseInt(isValidAge) > 120) {
				this.age = isValidAge;
				this.birthday = stringDate;
				checkBirthday = "invalidated";
				return;
			}

			Period p = Period.between(localDate, LocalDate.now());
			if (p.getYears() == Integer.parseInt(isValidAge)) {
				this.birthday = stringDate;
				this.age = isValidAge;
			} else {
				this.birthday = stringDate;
				this.age = isValidAge;
				checkAge = "invalidated";
			}

		} catch (Exception e) {
			this.age = isValidAge;
			checkAge = "invalidated";
			return;
		}
	}

}
