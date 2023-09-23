package com.uexcel.password.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

	public static void main(String[] args) {
		String password = "Hi09939w800w";
		PasswordValidation.passwordValidation1(password);
//		PasswordValidation.passwordValidation2(password);
	}

	public static void passwordValidation1(String password) {
		String[] regexPattern = { "[A-Za-z\\d]{8,15}", "[A-Z]+", "[a-z]+", "[0-9]+" };
		String[] message = { "The length of the password is not up to 8 or it's more than 15 characters!",
				"The password does not contain an upper case letter!",
				"The password does not contain a lower case letter!", "The password does not contain a digit number!"};
		boolean isValid = true;
		for (int i = 0; i < regexPattern.length; i++) {
			if (regexPattern[i].contains("A") && regexPattern[i].contains("d")) {
				isValid = Pattern.matches(regexPattern[i], password);
				if (!isValid) {
					System.out.println(message[i]);	
				}
			} else {
				Pattern match = Pattern.compile(regexPattern[i]);
				Matcher matcher = match.matcher(password);
				if (!matcher.find()) {
					System.out.println(message[i]);
					isValid = false;
				}
			}
		} if(isValid) {
			System.out.println("The password is valid!!");
		}
	}
	
	

	public static void passwordValidation2(String password) {
		String[] regexPattern = { "[A-Za-z\\d]{8,15}", "[A-Z]+", "[a-z]+", "[0-9]+" };
		
		boolean isValid = true;
		
		for (String n : regexPattern) {

			Pattern match = Pattern.compile(n);
			Matcher matcher = match.matcher(password);

			if (n.contains("A") && n.contains("d")) {
				isValid = Pattern.matches(n, password);
				if (!isValid) {
					System.out.println("The length of the password is not up to 8 or it's more than 15 characters!");
				}
			}

			if (!matcher.find() && !n.contains("d")) {

				if (n.contains("A")) {
					System.out.println("The password does not contain an upper case letter!");
					isValid = false;

				}

				if (n.contains("a")) {
					System.out.println("The password does not contain a lower case letter!");
					isValid = false;

				}

				if (n.contains("9")) {
					System.out.println("The password does not contain a digit!");
					isValid = false;

				}
			}
		}

		if (isValid) {
			System.out.println("The password is valid!");
		}

	}
}
