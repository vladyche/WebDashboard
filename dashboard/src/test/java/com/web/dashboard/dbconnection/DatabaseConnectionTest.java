package com.web.dashboard.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.web.dashboard.config.AppBeans;

public class DatabaseConnectionTest {
	private String url = "jdbc:postgresql://localhost:5432/test_web_dashboard";
	private String user = "postgres";
	private String pass = "pg123";
	
	@Test
	void jdbcConnection() {
		
		try {
			System.out.println("Connection...");
			Connection connect = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect! " + connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void hibernateConnection() {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			System.out.println("Connect " + session);
		}finally {
			sessionFactory.close();
			System.out.println("Closed!");
		}
	}
	
	@Test
	void installDB() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);		
	}
	
}
