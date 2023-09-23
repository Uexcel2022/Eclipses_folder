//package com.uexcel.validation;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;

//@Target (ElementType.TYPE) //class level application. use can further specify tyes like method or field like ElementType.TYPE.Methed
//@Retention(RetentionPolicy.RUNTIME) // Btw compiler and runtime--   On runtime
//@Constraint(validatedBy = AgeValidation.class ) //the class to process
//public @interface Age {
//    
//	String message() default "Age and birthday doesn't match!";
//	
//	Class<?> [] groups() default{};
//	public abstract Class<? extends Payload>[] payload() default{};
//	
//}
