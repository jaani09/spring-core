package com.rays.autowire.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("byConstructor.xml");

		UserService userService = (UserService) context.getBean("userService");
		userService.testAdd();
	}


}
