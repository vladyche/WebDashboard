package com.web.dashboard.dao.user;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dashboard.config.AppBeans;
import com.web.dashboard.dao.UserDao;
import com.web.dashboard.dao.impl.UserDaoImpl;
import com.web.dashboard.entity.Role;
import com.web.dashboard.entity.User;

public class UserDaoTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
	UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
	
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
	void testSaveUser() {		
		System.out.println();
		System.out.println(">>>>>>>testSaveUser");
		System.out.println();
		
		Role role = new Role();
		role.setId(2);
				
		User user = new User();
		user.setUsername("rbarettea");
		user.setPassword("d0z8pvqx");
        user.setFirstName("Henriette");
        user.setLastName("Cestard");
        user.setPatronymic("hcestard8");
        user.setEmail("hcestard8@usda.gov");
        user.setStatus(true);
        user.setRole(role);
        
        Assertions.assertEquals(user, userDao.save(user));
	}
	
	@Test
	void testFindUserById() {
		System.out.println();
		System.out.println(">>>>>>>testFindUserById");
		System.out.println();
		
		Role role = new Role();
		role.setId(2);
		role.setName("ADMIN");
		
		User userActual = new User();
		userActual.setId(11L);
		userActual.setUsername("sgilgryst0");
		userActual.setPassword("anYrIx7y");
        userActual.setFirstName("Joni");
        userActual.setLastName("Gilgryst");
        userActual.setPatronymic("Sallyann");
        userActual.setEmail("sgilgryst0@nifty.com");
        userActual.setStatus(false);
        userActual.setRole(role);
                
        User userExpected = userDao.findById(userActual.getId());
        
        System.out.println("actual: " + userActual);
        System.out.println("expected: " + userExpected.getRole());
			
		Assertions.assertEquals(userActual, userExpected);	
	}
	
	@Test
	void testGetUserRoleByUserId() {
		System.out.println();
		System.out.println(">>>>>>>testGetUserRoleByUserId");
		System.out.println();
		
		Assertions.assertEquals("MANAGER", userDao.findById(7L).getRole().getName());
	}
	
	@Test
	void testUpdateUser() {
		System.out.println();
		System.out.println(">>>>>>>testUpdateUser");
		System.out.println();
		
		User user = new User();
		user.setId(3L);
		user.setUsername("dlegrice2");
		user.setPassword("50o1smq");
        user.setFirstName("Janey");
        user.setLastName("LEGRICE");
        user.setPatronymic("Dru");
        user.setEmail("dlegrice2@youtu.be");
        user.setStatus(false);
        
        Assertions.assertEquals(user, userDao.update(user));
	}
	
	@Test
	void testFindUserByEmail() {
		System.out.println();
		System.out.println(">>>>>>>testFindUserByEmail");
		System.out.println();
		
		User user = new User();
		user.setId(10L);
		user.setUsername("awittey9");
		user.setPassword("Cd39XW3NQ");
        user.setFirstName("Findley");
        user.setLastName("Wittey");
        user.setPatronymic("Ardra");
        user.setEmail("awittey9@tmall.com");
        user.setStatus(false);   
		
		Assertions.assertEquals(user, userDao.findByEmail("awittey9@tmall.com"));
	}
	
	@Test
	void testUserFindAll() {
		System.out.println();
		System.out.println(">>>>>>>testUserFindAll");
		System.out.println();
		
		Assertions.assertEquals(10, userDao.findAll().size());
	}

	@Test
	void testDeleteCompletely() {
		System.out.println();
		System.out.println(">>>>>>>testDeleteCompletely");
		System.out.println();
		
		User user = new User();
		user.setId(11L);

		userDao.deleteCompletely(user);
	}
	
	@Test
	void testMarkForDelete() {
		System.out.println();
		System.out.println(">>>>>>>testMarkForDelete");
		System.out.println();

		userDao.markForDelete(5L);		
	}	
}
