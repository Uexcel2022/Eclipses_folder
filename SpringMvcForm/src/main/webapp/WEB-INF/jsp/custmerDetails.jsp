<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body>
<P>First name: ${customer.firstName}</p>
<p>Last name: ${customer.lastName}</p>
<p>Last name: ${customer.phone.areacode}-${customer.phone.prefix}-${customer.phone.number}</p>
</body>
</html>