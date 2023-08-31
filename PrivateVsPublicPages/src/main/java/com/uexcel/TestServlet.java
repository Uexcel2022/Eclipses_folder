package com.uexcel;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/testservlet")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.sendRedirect("WEB-INF/privatepage.jsp"); //does not  work for private in (web-INF)
		req.getRequestDispatcher("WEB-INF/privatepage.jsp").forward(req, resp); // The only way to access private pages
	}
	
	

}
