package com.uexcel.model;

import java.sql.*;

public class loginValidation {

	public static String getData(String username, String password) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String query = "SELECT FirstName FROM login WHERE UserName =? AND Password=? ";
			String user = "root", pass = "jvman19", url = "jdbc:mariadb://localhost:3306/mydatabase";
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				return rs.getString("FirstName");
			}
			return "";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return "error";
	}

//	public static void main(String[] args) {
//		System.out.println(Validation.getData("suitz01", "sweet19"));
//	}
}
