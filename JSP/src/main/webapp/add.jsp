<%@ page language="java" contentType="text/html charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">


<%
 int num1 = Integer.parseInt(request.getParameter("num1"));
 int num2 = Integer.parseInt(request.getParameter("num2"));
 out.println(String.format("Output: %s", num1+num2)+"\n"); 
 %>
 
 
 <p> <%="Result : "+ (Integer.parseInt(request.getParameter("num1")) 
		 +Integer.parseInt(request.getParameter("num2"))) %></p>
   
<%!String name = "Jide"; %> 

<%@page import = "java.util.Scanner"%>
</body>
</html>