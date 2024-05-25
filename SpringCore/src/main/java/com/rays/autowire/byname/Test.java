package com.rays.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("byName.xml");

		UserService userService = (UserService) context.getBean("userService");
		userService.testAdd();
	}


}
