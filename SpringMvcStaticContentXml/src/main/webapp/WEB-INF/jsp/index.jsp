<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home</h1>
	<img src="resources/images/dog.jpeg" />
	
	<img src="<spring:url value='/resources/taco.jpeg'/>" width=" 474" height="296" />

	<img src="abc/images/dog.jpeg" />
</body>
</html>