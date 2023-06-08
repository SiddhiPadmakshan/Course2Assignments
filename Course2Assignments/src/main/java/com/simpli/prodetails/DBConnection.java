package com.simpli.prodetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection;
	
	public DBConnection(String dburl, String username, String password) throws ClassNotFoundException, SQLException{
		// loading jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// connecting to the DB by calling this function
		this.connection = DriverManager.getConnection(dburl,username,password);
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() throws SQLException {
		if(this.connection != null) {
			this.connection.close();
		}
	}
	
	
}
