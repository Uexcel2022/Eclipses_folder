package com.uexcel.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class IncludeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
	resp.setContentType("text/plain");
		System.out.println("Before filter");
		req.setAttribute("name", "Nickson");
		filterChain.doFilter(req, resp);
		System.out.println("After filter");
		resp.getWriter().println("<br/>");
		resp.getWriter().println("After filter");
	}
	
}
