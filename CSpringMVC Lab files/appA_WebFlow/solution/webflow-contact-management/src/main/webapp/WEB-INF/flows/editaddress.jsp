<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit Contact</title>
</head>
<body>
<img src="logo.gif" />
<form:form method="post" commandName="address">
	<table border="1">
		<tr>
			<th>&nbsp;</th>
			<th>Address Info</th>
		</tr>
		<tr>
			<td bgcolor="cyan">Street:</td>
			<td><form:input path="street" size="40" /><font color="#FF0000"><form:errors
				path="street" /></font></td>
		</tr>
		<tr>
			<td bgcolor="cyan">City:</td>
			<td><form:input path="city" size="40" /><font color="#FF0000"><form:errors
				path="city" /></font></td>
		</tr>
		<tr>
			<td bgcolor="cyan">State:</td>
			<td><form:input path="state" size="40" /><font color="#FF0000"><form:errors
				path="state" /></font></td>
		</tr>
		<tr>
			<td bgcolor="cyan">ZIP</td>
			<td><form:input path="zip" size="40" /><font color="#FF0000"><form:errors
				path="zip" /></font></td>
		</tr>
		<tr>
			<td><input type="submit" name="_eventId_addressSaved"
				value="Save" /></td>
			<td><input type="reset" value="Reset" /></td>
		</tr>
	</table>
	<a href="index.jsp">Main Page</a>
</form:form>
</body>
</html>