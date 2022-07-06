package com.web.dashboard.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	void testEqualsName() {
		User user = new User();
		user.setFirstName("FirstName");
		Assertions.assertEquals("FirstName", user.getFirstName());		
	}
}
