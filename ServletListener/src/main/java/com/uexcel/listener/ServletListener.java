package com.uexcel.listener;

import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

import com.uexcel.db.DBConnection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		String url = context.getInitParameter("url");
		String driver = context.getInitParameter("driver");

		DBConnection dbconnection = new DBConnection();
		try {
			dbconnection.connection(driver, url, username, password);
			Connection db = (Connection) dbconnection.getConnection();
			context.setAttribute("db", db);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		Connection conn = (Connection) sce.getServletContext().getAttribute("db");
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
