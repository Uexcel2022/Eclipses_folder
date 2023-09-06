package com.uexcel.servlet;

import java.io.IOException;

import com.uexcel.model.loginValidation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String user = loginValidation.getData(username, password);

		if (user.equals("error")) {
			resp.sendRedirect("error.jsp?error=login");
		} else

		if (user.isEmpty()) {
			resp.sendRedirect("index.jsp?error=true");

		} else {
			HttpSession session = req.getSession();
			session.setAttribute("login", "true");
			session.setAttribute("user", user);
			resp.sendRedirect("welcome.jsp");
		}

	}

}
