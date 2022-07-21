package com.web.dashboard.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTest {
	
	@Test
	public void testEqualsName() {
		Role role = new Role();
		role.setName("ADMIN");
		Assertions.assertEquals("ADMIN", role.getName());		
	}
}
