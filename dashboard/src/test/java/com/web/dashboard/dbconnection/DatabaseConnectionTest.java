package com.web.dashboard.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
	
	@Test
	void jdbcConnection() {
		String url = "jdbc:postgresql://localhost:5432/test_web_dashboard";
		String user = "postgres";
		String pass = "pg123";
		
		try {
			System.out.println("Connection...");
			Connection connect = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect! " + connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
