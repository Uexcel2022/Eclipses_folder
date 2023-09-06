<%@page import="org.apache.tomcat.util.descriptor.web.TaglibDescriptorImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
<h2 style="color:white">We encountered error; unable to fulfill your <c:out value="${param.error }"></c:out> request!!!</h2>
<a href="index.jsp">Back to home page</a>
</body>
</html>