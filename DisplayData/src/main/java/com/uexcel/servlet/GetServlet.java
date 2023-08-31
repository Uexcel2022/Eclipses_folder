package com.uexcel.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.uexcel.model.FetchData;
import com.uexcel.dao.ConnectDatabase;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/addme")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FetchData dt = ConnectDatabase.getData(request.getParameter("username"));

		if (dt.getFirstName() == null && dt.getError()==null) {
			
			response.sendRedirect("index.jsp");
		} else {

			request.setAttribute("data", dt);
			RequestDispatcher rd = request.getRequestDispatcher("showdao.jsp");
			rd.forward(request, response);
		}
	}

}
