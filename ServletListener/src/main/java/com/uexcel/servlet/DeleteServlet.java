package com.uexcel.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		if (((String) req.getSession().getAttribute("confirm")) != null) {
			if (req.getParameter("confirmation") != null && req.getParameter("confirmation").equals("ok")) {
				resp.setContentType("text/html");
				session.invalidate();
				resp.getWriter().print("file deleted!");
				
			} else if (req.getParameter("confirmation") != null && req.getParameter("confirmation").equals("cancel")) {
				session.invalidate();
				resp.sendRedirect("servlet");
				
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("confirm", req.getParameter("phone"));
		resp.sendRedirect("confirmation.jsp");

	}
}
