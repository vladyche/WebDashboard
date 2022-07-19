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
		
		User user = new User();
        user.setFirstName("Henriette");
        user.setLastName("Cestard");
        user.setPatronymic("hcestard8");
        user.setEmail("hcestard8@usda.gov");
        user.setStatus(true);
        
        Assertions.assertEquals(user, userDao.save(user));
	}
	
	@Test
	void testFindUserById() {
		System.out.println();
		System.out.println(">>>>>>>testFindUserById");
		System.out.println();
		
		User user = new User();
		user.setId(9L);
        user.setFirstName("Henriette");
        user.setLastName("Cestard");
        user.setPatronymic("hcestard8");
        user.setEmail("hcestard8@usda.gov");
        user.setStatus(true);
			
		Assertions.assertEquals(user, userDao.findById(user.getId()));	
	}
	
	@Test
	void testUpdateUser() {
		System.out.println();
		System.out.println(">>>>>>>testUpdateUser");
		System.out.println();
		
		User user = new User();
		user.setId(3L);
        user.setFirstName("Harland");
        user.setLastName("Cutill");
        user.setPatronymic("hcutill2");
        user.setEmail("hcutill2@ed.gov");
        user.setStatus(false);
        
        Assertions.assertEquals(user, userDao.update(user));
	}
	
	@Test
	void testFindUserByEmail() {
		System.out.println();
		System.out.println(">>>>>>>testFindUserByEmail");
		System.out.println();
		
		User user = new User();
		user.setId(9L);
        user.setFirstName("Henriette");
        user.setLastName("Cestard");
        user.setPatronymic("hcestard8");
        user.setEmail("hcestard8@usda.gov");
        user.setStatus(true);   
		
		Assertions.assertEquals(user, userDao.findByEmail("hcestard8@usda.gov"));
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
		user.setId(9L);
        user.setFirstName("Henriette");
        user.setLastName("Cestard");
        user.setPatronymic("hcestard8");
        user.setEmail("hcestard8@usda.gov");
        user.setStatus(true);

		userDao.deleteCompletely(user);
	}
	
	@Test
	void testMarkForDelete() {
		System.out.println();
		System.out.println(">>>>>>>testMarkForDelete");
		System.out.println();

		userDao.markForDelete(11L);		
	}	
}
