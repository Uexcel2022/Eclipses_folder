package com.uexcel.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uexcel.connectdatabase.GetData;
import com.uexcel.createdataobjects.CreateDao;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<CreateDao> objs = GetData.getData();
			
			request.setAttribute("obj", objs);
			RequestDispatcher dt = request.getRequestDispatcher("showprofile.jsp");
			dt.forward(request, response);
				
		} catch ( SQLException e) {
			response.sendRedirect("error.jsp");
		}
	}
	


}
