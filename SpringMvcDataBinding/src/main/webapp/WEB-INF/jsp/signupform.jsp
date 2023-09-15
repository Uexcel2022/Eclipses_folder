<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
<form action="signup" method="post">
<p>First name: <input name="firstName"></p>
<p>Last name: <input name="lastName"></p>
<p>Address:</p>
<p> State: <input name="address.state"></p>
<p>Zipcode: <input name="address.zipcode"></p>
<p><input type="submit" value="Submit"></p>
</form>
</body>
</html>