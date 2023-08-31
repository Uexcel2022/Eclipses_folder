package com.uexcel;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException {
		
		int x = Integer.parseInt(req.getParameter("num1"));
		int y= Integer.parseInt(req.getParameter("num2"));
		int k = x+y;
		
		// To call a Servlet by a Servlet options.	
		//1 ResquestDispatcher 
		//2 Redirect
		
		req.setAttribute("K", k);
		
		RequestDispatcher rd = req.getRequestDispatcher("sqr");
		
	   rd.forward(req, resp);
	}
	
}
