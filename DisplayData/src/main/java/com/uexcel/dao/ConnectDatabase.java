package com.uexcel.dao;

import java.sql.*;

import com.uexcel.model.FetchData;

public class ConnectDatabase {

	public static FetchData getData(String username) {
		FetchData fd = new FetchData();

		String query = "Select FirstName,LastName, Gender, Phone from login Where Username = ?";
		String user = "root", pass = "jvman19", url = "jdbc:mariadb://localhost:3306/mydatabase";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				fd.setFirstName(rs.getString("FirstName"));;
				fd.setLastName(rs.getString("LastName"));
				fd.setGender(rs.getString("Gender"));
				fd.setPhone(rs.getString("Phone"));
			}

			return fd;

		} catch (SQLException|ClassNotFoundException  e) {
			fd.setError("exception");
			System.out.println(e);
			return fd;
		}
          
	}
	
	    public static void main(String[] args) {
		FetchData fd = ConnectDatabase.getData("uexcel247");
		System.out.println(fd.getFirstName());
	}
}
