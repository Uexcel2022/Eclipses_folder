package com.uexcel.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetData {

	public ArrayList<DBObject> getData(java.sql.Connection dbConnection) {
		DBObject obj;
		ArrayList<DBObject> objects = new ArrayList<>();

		try {
			PreparedStatement st = dbConnection
					.prepareStatement("SELECT FirstName, LastName, Gender, Phone, Email FROM login");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				obj = new DBObject();
				obj.setFirstName(rs.getString("FirstName"));
				obj.setLastName(rs.getString("LastName"));
				obj.setGender(rs.getString("Gender"));
				obj.setPhone(rs.getString("Phone"));
				obj.setEmail(rs.getString("Email"));

				objects.add(obj);
			}
			return objects;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objects;
	}
}
