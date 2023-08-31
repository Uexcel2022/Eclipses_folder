package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/sqr")
public class SqServlet extends HttpServlet {
 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 PrintWriter out = resp.getWriter();
  int sum = Integer.parseInt(req.getParameter("sum"));
  out.println(String.format("<html> <body> <p> The sqare of %s = %s  </p> </body> </html>", sum,sum*sum));
  
 }
}
