package mysql;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnector {

	public static Statement createStatemet() {
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:product.db";
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "CREATE TABLE IF NOT EXISTS Login(firstname varchar(30) Not NULL, lastname varchar(30)  Not NULL, gender varchar(10)  Not NULL, "
					+ "phone varchar(30)  Not NULL, email varchar(70)  Not NULL, username varchar(20)  Not NULL, password varchar(30)  Not NULL)";
			statement = conn.createStatement();
			statement.execute(query);
//			conn.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
          return statement;
	}

}
