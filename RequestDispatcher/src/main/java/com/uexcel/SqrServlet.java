package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SqrServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		int k = (int) req.getAttribute("K");
		int sqr = k * k;
		out.println(String.format("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Result</title>\r\n" + "</head>\r\n" + "<style>\r\n" + "	body{\r\n"
				+ "		text-align: center;\r\n" + "margin: 50px;\r\n" + "	}\r\n" + "</style>" + "<body>\r\n"
				+ "<p> The square of %s  is  %s</p>\r\n" + "</body>\r\n" + "</html>", k, sqr));

	}
}
