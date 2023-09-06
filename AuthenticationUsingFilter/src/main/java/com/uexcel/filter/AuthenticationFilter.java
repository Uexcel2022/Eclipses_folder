package com.uexcel.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String servletPath = request.getServletPath();
		if("/".equals(servletPath)|| "/login".equals(servletPath) || "/index.jsp".equals(servletPath)|| 
				"/error.jsp".equalsIgnoreCase(servletPath)) {
			  filterChain.doFilter(req, resp);
		} else {
			HttpSession session = request.getSession();
			String  login = (String) session.getAttribute("login");
			if(login != null) {
				 filterChain.doFilter(req, resp);
			} else {
				response.sendRedirect("index.jsp");
			}
			
		}
		
	}

}
