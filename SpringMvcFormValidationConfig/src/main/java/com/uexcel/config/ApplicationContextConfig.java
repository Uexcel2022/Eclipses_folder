package com.uexcel.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jakarta.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan("com.uexcel")
public class ApplicationContextConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
				
	}
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
//		resource.addBasenames("message", "errorMessages_en_US");
//		return resource;
//	}
//	
//	@Bean(name="validator")
//	public LocalValidatorFactoryBean validator() {
//		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//		bean.setValidationMessageSource(messageSource());
//		return bean;
//	}
//	
//	@Override
//	public LocalValidatorFactoryBean getValidator() {
//		return validator();
//	}
	
}
