package com.uexcel;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloForwardFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
		  Enumeration <String> names = filterConfig.getInitParameterNames();
		  while(names.hasMoreElements()) {
			  String name = names.nextElement();
			  System.out.println(name + ": "+ filterConfig.getInitParameter(name));
		  }
		}

		@Override
		public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
				throws IOException, ServletException {
			System.out.println("Forward: Before filter");
			req.setAttribute("author", "uexcel");
			filterChain.doFilter(req, resp);
			System.out.println("Forward: Atfer filter");
			resp.getWriter().println("<br/>");
			resp.getWriter().println("Forward: Atfer filter");
			
		}
		
		@Override
		public void destroy() {
			System.out.println("Destroyed");
		}
	}
