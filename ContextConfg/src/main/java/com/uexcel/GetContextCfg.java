package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//ServletConfig servlet specific while 

@SuppressWarnings("serial")
public class GetContextCfg extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		ServletConfig cg = getServletConfig();
		String x = cg.getInitParameter("name");
		out.println(x);
	}
}
