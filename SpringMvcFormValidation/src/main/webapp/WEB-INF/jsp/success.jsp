<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>User Saved Successfully!</h1>
<p>Username: ${user.username}</p>
<p>Email: ${user.email}</p>
<p>Age: ${user.age}</p>
<p>Birthday: ${user.birthday}</p>
 <p>Role: ${user.role }</p>
 <p></p>
 <p><strong>Address info: </strong></p>
 <p>Street: ${user.addr.street }</p>
 <p>State: ${user.addr.state}</p>
 <p>Zipcode: ${user.addr.zipCode}</p>
</body>
</html>