package mysql;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	 
	/**
	 * This program demonstrates making JDBC connection to a SQLite database.
	 * @author www.codejava.net
	 *
	 */
	public class JdbcSQLiteConnection {
	 
	    public static void main(String[] args) {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            String dbURL = "jdbc:sqlite:product.db";
	            Connection conn = DriverManager.getConnection(dbURL);
	            String query = "CREATE TABLE IF NOT EXISTS Login(firstname varchar(30) Not NULL, lastname varchar(30)  Not NULL, gender varchar(10)  Not NULL, "
						+ "phone varchar(30)  Not NULL, email varchar(70)  Not NULL, username varchar(20)  Not NULL, password varchar(30)  Not NULL)";
				java.sql.Statement statement = conn.createStatement();
				statement.execute(query);
				
//	            if (conn != null) {
//	                System.out.println("Connected to the database");
//	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//	                System.out.println("Driver name: " + dm.getDriverName());
//	                System.out.println("Driver version: " + dm.getDriverVersion());
//	                System.out.println("Product name: " + dm.getDatabaseProductName());
//	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
	                conn.close();
//	            }
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        
	    }
	}


