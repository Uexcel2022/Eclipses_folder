<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<style>
 .error{
 color:red;
 }
</style>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
<h1>Add new User:</h1>
<form:form modelAttribute="user"  action="add">
<p>Username: <form:input path="username" /> <form:errors path="username" class="error"/></p>
<p>Email:  <form:input path="email"/><form:errors path="email" class="error"/></p>
<p>Age: <form:input path="age"/><form:errors path="age" class="error"/></p>
<p> BirthDay: <form:input  path="birthday" /><form:errors path="birthday" class="error"/></p>
<p><form:select path="role">
  <form:option value="">Select Role</form:option>
  <form:options items="${roles}"/>
</form:select><form:errors path="role" class="error"/></p>
<p><strong>Address: </strong></p>
<p>Street: <form:input path="addr.street"/><form:errors path="addr.street" class="error"/></p>
<p>State: <form:input path="addr.state"/><form:errors path="addr.state" class="error"/></p>
<p>Zip code: <form:input path="addr.zipCode"/><form:errors path="addr.zipCode" class="error"/></p>

<input type="submit" value="Add"/>
</form:form>

</body>
</html>