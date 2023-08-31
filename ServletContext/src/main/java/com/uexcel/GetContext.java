package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetContext extends HttpServlet {
	
	//Many Server shares one Servlet Context; Servlet context is fall the servlets
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		ServletContext ctx = getServletContext();
		String str = ctx.getInitParameter("name");
		String str2 = ctx.getInitParameter("Phone");
		out.println(String.format("<html><p>Hi %s, we have %s 13 promax.</p><body></body></html",str,str2));
		
	}

}
