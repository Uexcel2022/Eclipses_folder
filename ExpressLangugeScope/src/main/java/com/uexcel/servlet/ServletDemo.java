package com.uexcel.servlet;

import java.io.IOException;

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
		req.setAttribute("scope", "request attribute");
		req.getServletContext().setAttribute("scope", "Servlet context");
		req.getSession().setAttribute("scope", "session");
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}

}
