<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp" import="java.sql.*"%>
<%@ page import="com.uexcel.model.FetchData"%>
<%@ page import="java.sql.SQLException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sq" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>

<body>
	<c:set var="a" value="index.jsp"></c:set>

	<c:set value="${data.getError()}" scope="session" var="error"></c:set>
	<c:set value="${data}" scope="session" var="obj"></c:set>

	<c:choose>

		<c:when test="${error == null }">
    First name: <c:out value="${data.getFirstName()}"></c:out>
			<br>
	Last name: <c:out value="${data.getLastName()}"></c:out>
			<br>
	Gender: <c:out value="${data.getGender()}"></c:out>
			<br>
	Phone: <c:out value="${data.getPhone()}"></c:out>
			<br>
		</c:when>

		<c:otherwise>
			<c:redirect>error.jsp</c:redirect>
		</c:otherwise>

	</c:choose>

	<br>
	
	<c:forEach items="${data.toString()}" var="d">
		<br>
		<c:out value="${d}"></c:out>
	</c:forEach>
	<br>
	<a href="${a}">Back to Home</a>

	<c:set var="greet" value="Hello good day"></c:set>
	<c:if test="${fn: contains(greet, 'day')}">
		<p>Ok</p>
	</c:if>


</body>
</html>




