package com.uexcel;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

@WebServlet("/appcontext")
public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("author", "Uoka");
		ctx.setAttribute("app", "Test Servlet context");
		response.getWriter().append("Servlet context set successfully");
	}
}
