<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="customer/savecustomer" method="post">
<p>First name: <input name="firstName"></p>
<p>Last name: <input name="lastName"></p>
<p>Phone: <input name="phone" placeholder="122-1282-2891" pattern="[0-9]+-[0-9]+-[0-9]+" ></p>
<input  type="submit" value="Submit">
</form>
</body>
</html>