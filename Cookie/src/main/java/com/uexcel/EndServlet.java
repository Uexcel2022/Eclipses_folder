package com.uexcel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.Stream;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EndServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		Cookie[] cks = req.getCookies();
		resp.setContentType("text/html");

		out.println("Sum: " + this.getCookieValueByName(cks, "k").get());
		out.print("<br>");
		out.println("Square: " +getCookieValue(cks, "k") );
	}

	private Optional<String> getCookieValueByName(Cookie[] cookies, String name) {
		return Stream.of(cookies).filter(cookie -> name.equals(cookie.getName())).map(Cookie::getValue).findAny();
	}

	public String getCookieValue(Cookie[] cookies, String name) {

		for (Cookie n : cookies) {
			if (n.getName().equals(name)) {
				int k = Integer.parseInt(n.getValue());
				Integer j = k * k;

				return j.toString();
			}

		}
		return null;
	}
}
