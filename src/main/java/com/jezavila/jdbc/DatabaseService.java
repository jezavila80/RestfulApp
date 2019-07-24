package com.jezavila.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {
	private static Connection dbservice;
	
	public static Connection getConnection() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/escuela?useSSL=false";
		String user = "admin";
		String pass = "password";
		String driver = "com.mysql.jdbc.Driver";
		try {
			if (dbservice != null && !dbservice.isClosed()) {
				return dbservice;
			}
			System.out.println("Loading driver");
			Class.forName(driver);
			System.out.println("Connecting to database: " + jdbcUrl);
			dbservice = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbservice;
	}
	
	public static boolean closeConnection() {
		try {
			dbservice.close();
			System.out.println("Connection closed!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
