package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	 resp.setContentType("text/html");
	 out.println("Application: "+ req.getServletContext().getAttribute("app"));
	 out.print("<br>");
	 out.println("Author: "+ req.getServletContext().getAttribute("author"));
	 
	 //Servlet context is not thread safe.
	 //Request scope is thread safe.
		
	}

}
