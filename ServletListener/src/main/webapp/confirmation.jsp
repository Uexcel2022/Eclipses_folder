<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm</title>
</head>
<body>
<h4>You are about to delete a profile... Please note; it can not be undone!</h4>
<c:url value="delete" var="yes">
<c:param name="confirmation" value="ok"></c:param>
</c:url>

<c:url value="delete" var="no">
<c:param name="confirmation" value="cancel"></c:param>
</c:url>

<a href="${no}">Cancel</a>     <a href="${yes}">OK</a>

</body>
</html>