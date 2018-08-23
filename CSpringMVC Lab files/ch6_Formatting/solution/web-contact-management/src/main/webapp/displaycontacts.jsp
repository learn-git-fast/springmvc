<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script type="text/javascript">
	function confirmDelete(lastname, firstname) {
		return confirm("Are you sure you wish to delete " + firstname + " "
				+ lastname + " contact?");
	}
	//
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<img src="logo.gif" />
	<table border="1">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Date of birth</th>
			<th>Married</th>
			<th>Children</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">
			<tr>
				<td>${contact.firstName }</td>
				<td>${contact.lastName }</td>
				<td>${contact.dateOfBirth }</td>
				<td>${contact.married}</td>
				<td>${contact.children }</td>
				<td><a href="deletecontact.request?id=${contact.id}"
					onclick="return confirmDelete('${contact.lastName}', '${contact.firstName}')">Delete</a>
					<a href="editcontact.request?id=${contact.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp">Main page</a>
</body>
</html>