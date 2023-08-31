<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
<%-- El  ${variable}  searches all scope and start from page context or scope--%>
<%
     pageContext.setAttribute("scope", "page context");
%>

  <p>Scope: ${scope}</p>
  
  <%--Using El implicit objects to get all the value from different scope --%>
  <p>Page scope: ${pageScope.scope}</p>
  <p>Request scope: ${requestScope.scope}</p>
  <p>Session scope: ${sessionScope.scope}</p>
  <p>App scope: ${applicationScope.scope}</p>
</body>
</html>