<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
<h1>Create Account</h1>
<form:form action="submitform"  modelAttribute="customer" method="post">
<p>First name  <form:input  path="firstName" /> </p>
<p>Last name <form:input path="lastName" /></p>
<p>Phone <form:input path="phone" /></p>
<input type="submit" value="Submit" />
</form:form>
</body>
</html>