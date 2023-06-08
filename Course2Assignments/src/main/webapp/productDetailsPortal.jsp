<%@page import="com.simpli.hibernateEntities.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details Entered</title>
</head>
<body>
<%
if(session.getAttribute("newProductDetails") == null){
	response.sendRedirect("productDetailsPortal.html");
}
 
	Product trial = (Product) session.getAttribute("newProductDetails");
%>
<h3>Product ID: <%=trial.getID()%></h3>
<h3>Product Name: <%=trial.getName()%></h3>
<h3>Product Price: <%=trial.getPrice()%></h3>
<h3>Product Added Date: <%=trial.getDateAdded()%></h3><br>

<a href="logout.jsp">Click here to logout.</a>
</body>
</html>