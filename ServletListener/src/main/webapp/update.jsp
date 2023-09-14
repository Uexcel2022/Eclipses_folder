<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<h3>Update profile:</h3>
<form action="updateservlet" method="post">
         <input value="update" hidden="on" name="update">
		First name: <input value="${param.fName}" name="fName" required="required"><br />
		Last name: <input value="${param.lName}" name="lName" required="required"><br />
		Gender: <input value="${param.gender}" name="gender" required="required"><br />
		Phone: <input value="${param.phone}" name="phone" required="required"><br />
		Email: <input value="${param.email}" name="email" required="required"><br />
		<button type="submit">Submit</button>
		</form><a href="servlet"><button>Cancel</button></a>
		
</body>
</html>