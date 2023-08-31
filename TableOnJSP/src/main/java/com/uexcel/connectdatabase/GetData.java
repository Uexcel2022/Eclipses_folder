package com.uexcel.connectdatabase;
import java.sql.*;
import java.util.ArrayList;
import com.uexcel.createdataobjects.CreateDao;

public class GetData {
	
	public static ArrayList<CreateDao> getData()
			throws  SQLException{
		ArrayList<CreateDao> objs = new ArrayList<>();
		CreateDao dao;
		String url="jdbc:mariadb://localhost:3306/mydatabase", user="root", pass="jvman19";
		String query = "SELECT FirstName, LastName, Gender, Phone FROM login";
		
	    try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	    Connection con = DriverManager.getConnection(url,user,pass);
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while(rs.next()) {
	    	dao = new CreateDao();
	    	dao.setFirstName(rs.getNString(1));
	    	dao.setLastName(rs.getNString(2));
	    	dao.setGender(rs.getNString(3));
	    	dao.setPhone(rs.getNString(4));
	    	objs.add(dao);
	    }
	    
	    return objs;
	}
	
//	public static void main(String[] args) {
//		
//			ArrayList<CreateDao> objs;
//			try {
//				objs = GetData.getData();
//				for(CreateDao obj : objs) {
//					System.out.println(obj.getFirstName());
//					System.out.println(obj.getLastName());
//					System.out.println(obj.getGender());
//					System.out.println(obj.getPhone());
//				}
//			} catch (SQLException e) {
//			
//				e.printStackTrace();
//			}
//			
//			
//	}
	
}
