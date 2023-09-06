package com.uexcel.filter;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(servletNames ={"servlet"}, urlPatterns={"/web/*"}, initParams= {@WebInitParam(name="name", value="AnnotationFilter")},
dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AnnotationFilter implements Filter {
@Override
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
		throws IOException, ServletException {
	filterChain.doFilter(req, resp);
	resp.getWriter().append("This from filter");
}
}
