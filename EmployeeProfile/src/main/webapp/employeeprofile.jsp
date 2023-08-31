<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>EmpID ${emp.empID} </p>
<p>First name ${emp.firstName} </p>
<p>Last name ${emp.lastName} </p>
<p>Address: </p>
<p>City: ${emp.address.street} </p>
<p>Town: ${emp.address.city} </p>
<p>State: ${emp.address.state} </p>
<br>
<p> ${emp.empID} ${emp2.firstName} ${emp2.lastName} </p>
<p>Address: ${emp2.address.street} ${emp2.address.city} ${emp2.address.state} </p>

<%-- using [] and "" to access the value --%>
 <br>
 
<p>EmpID ${emp["empID"]} </p>
<p>First name ${emp["firstName"]} </p>
<p>Last name ${emp["lastName"]} </p>
<p>Today: ${requestScope["foo.bar"]} </p>
<p>Fruits: ${fruits[0]}  ${fruits[1]}  ${fruits[2]} </p>


</body>
</html>