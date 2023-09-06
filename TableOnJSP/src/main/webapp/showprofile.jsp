<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp" import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sq" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	font-famaily: arial, sans-serif;
	boder-collapse: collapse;
	width: 100%
}

td, th {
	boder: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<body>

	<c:if test="${obj.get(0).getFirstName() == null }">

		<c:redirect>response.sendRedirect("error.jsp")</c:redirect>;
          
 </c:if>

	<table>
		<tr>
		    <th>Index</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Phone</th>
		</tr>
	
		<c:forEach items="${obj}" var="data" varStatus="status">
		<%-- i didnt's add this ${status.index}  --%>
			<tr>
			     <td>${status.count}</td>
				<td>${data.getFirstName()}</td>
				<td>${data.getLastName()}</td>
				<td>${data.getGender()}</td>
				<td>${data.getPhone()}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	  <a href="<c:url value="index.jsp"></c:url>" >Back</a>
</body>
</html>