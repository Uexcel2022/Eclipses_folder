package com.uexcel.db;

import java.sql.*;

public class DBConnection {
	private Connection connection;

	public void connection(String driver, String url, String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);

		connection = DriverManager.getConnection(url, username, password);
	}

	public Connection getConnection() {
		return this.connection;
	}

}
