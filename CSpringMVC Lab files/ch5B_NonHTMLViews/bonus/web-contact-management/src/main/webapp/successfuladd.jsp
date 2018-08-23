<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Added</title>
</head>
<body>
<img src="logo.gif" />
<h3>Contact Added</h3>
<table border="1">
	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Date of birth</th>
		<th>Married</th>
		<th>Children</th>
	</tr>
	<tr>
		<td>${contact.firstName }</td>
		<td>${contact.lastName }</td>
		<td>${contact.dateOfBirth }</td>
		<td>${contact.married}</td>
		<td>${contact.children }</td>
	</tr>
</table>
<a href="index.jsp">Main page</a>
</body>
</html>