package com.web.dashboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dashboard.config.AppBeans;
import com.web.dashboard.entity.Role;
import com.web.dashboard.service.impl.RoleServiceImpl;

public class RoleServiceTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
	RoleService roleService = context.getBean("roleService", RoleServiceImpl.class);
	
	@Test
	void testCreateRole() {
		Role role = new Role();
		role.setName("SUPERROLE");
		
		Assertions.assertEquals(role, roleService.create(role));
	}
	
	@Test
	void testReadById() {
		Assertions.assertEquals("MANAGER", roleService.readById(3).getName());		
	}
	
	@Test
	void testUpdate() {
		Role role = new Role();
		role.setId(3);
		role.setName("SUPERMANAGER");
		
		Assertions.assertEquals("SUPERMANAGER", roleService.update(role).getName());		
	}
	
	@Test
	void testDelete() {
		Role role = new Role();
		role.setId(55);
		
		roleService.delete(role);
	}
	
}
