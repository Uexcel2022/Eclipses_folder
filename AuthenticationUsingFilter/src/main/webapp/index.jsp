<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	width: 100px;
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no -cache, no-store, must-revalidate"); //http 1.1
	response.setHeader("Pragma", "no -cache"); // http 1.0
	response.setHeader("Expires", "0"); //Proxies
	%>
	<form action="login" method="post">
		<fieldset>
			<c:if test="${param.error }">
				<h5>
					<c:out value="Invalid username/password!"></c:out>
				</h5>
			</c:if>
			<legend>
				<strong>Log in</strong>
			</legend>
			<label>Useranme:</label><br /> <input name="username"
				autocomplete="off" required="required"><br /> <label>Password:</label><br /> <input
				type="password" name="password" autocomplete="off" required="required"><br />
			<input type="submit" value=Submit>
		</fieldset>
	</form>

</body>
</html>