package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SecondaryServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		int k = (int) session.getAttribute("k");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int j = k*k;
		out.println(j);
	}

}
