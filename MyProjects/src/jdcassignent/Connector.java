package jdcassignent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Connector {
	public static Statement createStatement() {
		Statement statement = null;
		String username = "root";
		String password = "jvman19";
		String url;
		url = "jdbc:mariadb://localhost:3306/mydatabase";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Sorry, we encountered error!", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		return statement;
	}
}
