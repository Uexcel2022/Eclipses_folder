<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Expression</title>
</head>
<body>
<h3>Fall silently when there is no return value</h3>
<p>First name: ${emp.firsetName}</p>

<h3>Return zero when multiply integer is multiply by null</h3>
<p>First name: ${100*emp.salary}</p>

<h3> takes null as false</h3>
<p> Salary : ${true and emp.salary}</p>

</body>
</html>