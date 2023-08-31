package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	public static Statement creatStatment() {
		Statement statement = null;
		String userName = "root", password = "";
		try {
			String url = "jdbc:mysql://localhost:3306/welcome";
			Connection connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement();
			String query = "CREATE TABLE IF NOT EXISTS Login(firstname varchar(30) Not NULL, lastname varchar(30)  Not NULL, gender varchar(10)  Not NULL, "
					+ "phone varchar(30)  Not NULL, email varchar(70)  Not NULL, username varchar(20)  Not NULL, password varchar(30)  Not NULL)";
			statement.execute(query);
//			System.out.println("Table Created");
		
		} catch (SQLException e) {
			System.out.println("Error! " + e);
		}
		return statement;
	}

}
