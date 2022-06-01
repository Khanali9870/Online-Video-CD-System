package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection connection;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vcdsystem","root","root");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
		
	}

}
