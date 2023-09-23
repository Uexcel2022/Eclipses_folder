<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order form</title>
</head>
<body>
<form:form action="saveOrder" method="post" modelAttribute="order">

<p>Product name: <form:input path="productName" /></p>
<p>Product Qty: <form:input  path="quantity"/></p>

<input type="submit" value="Place order"/>

</form:form>
</body>
</html>