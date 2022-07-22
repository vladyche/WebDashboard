package com.web.dashboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dashboard.config.AppBeans;
import com.web.dashboard.entity.Role;
import com.web.dashboard.entity.User;
import com.web.dashboard.service.impl.UserServiceImpl;

public class UserServiceTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
	UserService userService = context.getBean("userService", UserServiceImpl.class);
	
	@Test
	void createUserTest() {
		Role role = new Role();
		role.setId(3);
		
		User userActual = new User();
		userActual.setUsername("gstanifortha");
		userActual.setPassword("9B9JEotuR");
		userActual.setFirstName("Sandor");
		userActual.setLastName("Ivain");
		userActual.setPatronymic("Queyeiro");
		userActual.setEmail("sivaine@oakley.com");
		userActual.setRole(role);
		
		User userExpected = userService.create(userActual);
		
		Assertions.assertEquals(userActual, userExpected);								
	}
	
	@Test
	void readUserById() {
		Assertions.assertEquals(2L, userService.readById(2L).getId());
	}
	
	@Test
	void readUserByEmail() {
		String emailActual = "dscapens1@pcworld.com";
		String emailExpected = userService.readByEmail("dscapens1@pcworld.com").getEmail();
		Assertions.assertEquals(emailActual, emailExpected);
	}
	
	@Test
	void readAll() {
		Assertions.assertEquals(10, userService.readAll().size());
	}
	
}
