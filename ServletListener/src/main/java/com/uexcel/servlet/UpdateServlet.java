package com.uexcel.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	HttpSession session = req.getSession();
	if (((String) req.getSession().getAttribute("update")) != null
			&& ((String) req.getSession().getAttribute("update")).equals("update")) {
		session.invalidate();
		resp.getWriter().print("Profile updated!");
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	if (req.getParameter("update") != null && req.getParameter("update").equals("update")) {
		session.setAttribute("update", req.getParameter("update"));
		resp.sendRedirect("updateservlet");
	}
	}
}
