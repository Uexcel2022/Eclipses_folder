package com.uexcel.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name="helloServlet", urlPatterns={"/"})
public class Hello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In the servlet before include");
		req.getRequestDispatcher("include.jsp").include(req, resp);
		System.out.println("In the servlet after include");
		resp.getWriter().println("<br/>");
		resp.getWriter().println("In the servlet after Include ");
	}

}
