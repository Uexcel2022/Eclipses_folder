<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
label {
	line-height: 32px;
}

fieldset {
	width: 100px;
	border-style: 0.5px;
}

body {
	display: flex;
	justify-content: center;
}
</style>

<body>
	<section>
		<form action="signup.jsp" method="post">
			<fieldset>
				<legend>personal info:</legend>

				<label>First name: </label><br> <input name="fName" ><br>
				<label>Last name: </label><br> <input name="lName"><br>
				<label>Email: </label><br> <input type="email" name="email"><br>
				<label>Password: </label><br> <input type="password"
					name="password"><br>
					<label> Confirm Password: </label><br> <input type="password"
					name="confirmPassword"><br> 
					
					<input type="radio" name="gender" value="male"><label>male
				</label> <input type="radio" name="gender" value="female"> <label>female</label><br>

				<button type="submit">Submit</button>

			</fieldset>
		</form>
	</section>
</body>
</html>