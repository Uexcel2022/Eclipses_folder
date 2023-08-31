package pkg;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Add extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		PrintWriter out = resp.getWriter();
		Double result = num1 + num2;

		String[] check = String.valueOf(result).split("\\.");

		if (check[1].equals("0")) {
			out.println("The result: " + check[0]);
		} else
			out.println("The result: " + result);
	}
}
