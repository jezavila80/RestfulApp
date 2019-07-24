package com.jezavila.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

	public static void main(String [] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/escuela?useSSL=false";
		String user = "admin";
		String pass = "password";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful");
			PreparedStatement ps = myConn.prepareStatement("Select * From alumnos where id_alumno = 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(
						"Nombre: " + rs.getString("nombres") +
						"Apellido Pat: " + rs.getString("apellido_pat") +
						"Apellido Mat: " + rs.getString("apellido_mat"));
			}
			try { rs.close(); } catch (Exception ex1) {}
			try { ps.close(); } catch (Exception ex1) {}
			myConn.close();
			System.out.println("Connection close");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
