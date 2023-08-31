package com.uexcel.servlet;

import java.io.IOException;
import java.util.Arrays;

import com.uexcel.model.EmployeeAddress;
import com.uexcel.model.EmployeeData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeData data = new EmployeeData(100, "uexcel", "cute");
		EmployeeAddress address = new EmployeeAddress("House 12 First Ave", "Festac Town", "Lagos");
		data.setAddress(address);
		
		EmployeeData data2 = new EmployeeData(102, "Victor", "Tolu");
//		EmployeeAddress address2 = new EmployeeAddress("No 12 Awolo way", "Ikeja", "Lagos");
//		data2.setAddress(address2);
		
		req.setAttribute("fruits", Arrays.asList("Apple","Banan", "Orange"));
		req.setAttribute("foo.bar", "Monday");
		
		req.setAttribute("emp", data);
		req.setAttribute("emp2", data2);
		
		req.getRequestDispatcher("employeeprofile.jsp").forward(req, resp);
	}
     
}
