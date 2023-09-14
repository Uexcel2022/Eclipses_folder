package com.uexcel.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.uexcel.model.DBObject;
import com.uexcel.model.GetData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/servlet")
public class ServletDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GetData db = new GetData();
		
		ArrayList<DBObject> dbObjects = db.getData(((Connection) req.getServletContext().getAttribute("db")));
		
		req.setAttribute("objs", dbObjects );
		req.getRequestDispatcher("view.jsp").forward(req, resp);
		
	}
}
