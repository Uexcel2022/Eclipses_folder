package com.uexcel;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns= "/addme",  initParams= {@WebInitParam(name="title", value="cool" ), 
		@WebInitParam(name="style", value="annotation")} )
public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().append("<html><body>");
		resp.getWriter().append(" Servlet config name: "+getInitParameter("title")); 
	    resp.getWriter().append("<br>");
		resp.getWriter().append("Servlet config value: "+getInitParameter("style"));
		  resp.getWriter().append("<br>");
		resp.getWriter().append("Servlet context name: "+getServletContext().getInitParameter("name"));
		  resp.getWriter().append("<br>");
		resp.getWriter().append("Servlet ccontext value: "+getServletContext().getInitParameter("Phone"));
		resp.getWriter().append("</body></html>");
	}
 
}
