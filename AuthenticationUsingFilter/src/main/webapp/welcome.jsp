<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
	response.setHeader("Pragma", "no -cache"); // http 1.0
	response.setHeader("Expires", "0"); //Proxies
	%>
	<h1>
		Welcome,
		<c:out value="${user}"></c:out>...</h1>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>