package com.uexcel.validation;

import java.time.LocalDate;
import java.time.Period;

import com.uexcel.domain.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//public class AgeValidation implements ConstraintValidator<Age, User> {
//
//	@Override
//	public boolean isValid(User user, ConstraintValidatorContext context) {
////	 Period p = Period.between(user.getBirthday(), LocalDate.now());
//	 System.out.println(p.getYears() == Integer.parseInt(user.getAge()));
//	 return p.getYears() == Integer.parseInt(user.getAge());
//	}
//	
//	@Override
//	public void initialize(Age constraintAnnotation) {
//		
//	}

//}
