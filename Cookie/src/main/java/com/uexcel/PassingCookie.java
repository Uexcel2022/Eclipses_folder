package com.uexcel;

import java.io.IOException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PassingCookie extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		int x = Integer.parseInt(req.getParameter("num1"));
		int y = Integer.parseInt(req.getParameter("num2"));
		int k = x+y;
		
		Cookie ck = new Cookie("k", k+"");
		ck.setMaxAge(60*10); //10 minutes. default is session scope. it's removed when browser is exited.
		resp.addCookie(ck);
		
		resp.sendRedirect("end");
	}

}
