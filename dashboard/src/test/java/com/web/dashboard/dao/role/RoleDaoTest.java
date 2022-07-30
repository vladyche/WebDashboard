package com.web.dashboard.dao.role;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dashboard.config.beans.AppBeans;
import com.web.dashboard.dao.RoleDao;
import com.web.dashboard.dao.UserDao;
import com.web.dashboard.dao.impl.RoleDaoImpl;
import com.web.dashboard.dao.impl.UserDaoImpl;
import com.web.dashboard.entity.Role;

public class RoleDaoTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
	RoleDao roleDao = context.getBean("roleDao", RoleDaoImpl.class);
	
	@BeforeAll
	static void beforeAll(){
		System.out.println();
		System.out.println("@BeforeAll");
		System.out.println();
	}
	
	@AfterAll
	static void afterAll(){
		System.out.println();
		System.out.println("@AfterAll");
		System.out.println();
	}

	@BeforeEach
	void setupThis(){
		System.out.println();
		System.out.println("@BeforeEach");
		System.out.println();
	}
	
	@AfterEach
	void afterEach(){
		System.out.println();
		System.out.println("@AfterEach");
		System.out.println();
	}
	
	@Test
	public void findByIdTest() {
		System.out.println("");
		System.out.println(">>>>>>>>>>findByIdTest");	
		System.out.println("");
		
		Role role = new Role();
		role.setId(2);
		role.setName("ADMIN");
		
		Assertions.assertEquals(role, roleDao.findById(role.getId()));		
	}
	
	@Test
	public void findAll() {
		System.out.println("");
		System.out.println(">>>>>>>>>>findAll");	
		System.out.println("");
		
		Assertions.assertEquals(4, roleDao.findAll().size());
	}
	
	@Test
	public void saveTest() {
		System.out.println("");
		System.out.println(">>>>>>>>>>saveTest");	
		System.out.println("");	
		
		Role role = new Role();
		role.setName("DIRECTOR");
		
		Assertions.assertEquals(role, roleDao.save(role));		
	}
	
	@Test
	public void updateTest() {
		System.out.println("");
		System.out.println(">>>>>>>>>>updateTest");	
		System.out.println("");		
		
		Role role = new Role();
		role.setId(3);
		role.setName("SUPER-MANAGER");
		
		Assertions.assertEquals(role, roleDao.update(role));		
	}
	
	@Test
	public void deleteTest() {
		System.out.println("");
		System.out.println(">>>>>>>>>>deleteTest");	
		System.out.println("");	
		
		Role role = new Role();
		role.setId(55);
		role.setName("SUPERMANAGER");
		
		roleDao.delete(role);
	}
	
}
