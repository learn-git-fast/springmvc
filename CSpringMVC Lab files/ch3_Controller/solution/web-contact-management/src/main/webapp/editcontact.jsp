<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit Contact</title>
</head>
<body>
<img src="logo.gif" />
<form action="addcontact.request" method="post">
<table border="1">
	<tr>
		<th>&nbsp;</th>
		<th>Contact Info</th>
	</tr>
	<tr>
		<td bgcolor="cyan">First name:</td>
		<td><input type="text" name="firstName" size="40" /></td>
	</tr>
	<tr>
		<td bgcolor="cyan">Last name:</td>
		<td><input type="text" name="lastName" size="40" /></td>
	</tr>
	<tr>
		<td bgcolor="cyan">Date of birth</td>
		<td><input type="text" name="dateOfBirth" size="40" /></td>
	</tr>
	<tr>
		<td bgcolor="cyan">Married:</td>
		<td><input type="checkbox" name="married" /></td>
	</tr>
	<tr>
		<td bgcolor="cyan">Children</td>
		<td><input type="text" name="children" size="5" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Save" /></td>
		<td><input type="reset" value="Reset" /></td>
	</tr>
</table>
<a href="index.jsp">Main page</a></form>
</body>
</html>