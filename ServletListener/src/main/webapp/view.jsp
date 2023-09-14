<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>

	<c:forEach items="${objs}" var="obj">
		<label>First name: <c:out value="${obj.firstName}"></c:out></label><br/>
		<label>Last name: <c:out value="${obj.lastName}"></c:out></label><br/>
		<label>Gender: <c:out value="${obj.gender}"></c:out></label><br/>
		<label>Phone: <c:out value="${obj.phone}"></c:out></label><br/>
		<label>Email: <c:out value="${obj.email}"></c:out></label><br/>
		
		<form action="delete" method="post">
		<input value="${obj.phone}" hidden="on"  name="phone">
		<button type="submit">Delete</button>
		</form>
		<br/>
		
		<form action="update.jsp" method="post">
		<input value="${obj.firstName}" hidden="on"  name="fName">
		<input value="${obj.lastName}" hidden="on"  name="lName">
		<input value="${obj.gender}" hidden="on"  name="gender">
		<input value="${obj.phone}" hidden="on"  name="phone">
		<input value="${obj.email}" hidden="on"  name="email">
		<button type="submit">Update</button>
		</form>
		<br/>
	</c:forEach>
	
</body>
</html>