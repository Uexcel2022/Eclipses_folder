package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Servlet life cycle
//in it, service and distroyer

@SuppressWarnings("serial")
public class CalledServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp ) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int k = Integer.parseInt(req.getParameter("k"));
		int j = k*k;
		out.println(j);
	}

}
