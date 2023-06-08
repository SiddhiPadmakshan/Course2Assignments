<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
</head>
<body>

	<%
	session.invalidate();
	%>

	<b>Your session has terminated.</b>
	<br>
	<br>
	<a href="productDetailsPortal.html">Add New Product Again</a>


</body>
</html>