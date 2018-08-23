<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="editcontact.title" /></title>
</head>
<body>
	<img src="logo.gif" />
	<form:form action="addcontact.request" method="post"
		commandName="contact">
		<table border="1">
			<tr>
				<th>&nbsp;</th>
				<th><spring:message code="editcontact.heading" /></th>
			</tr>
			<tr>
				<td bgcolor="cyan"><spring:message
						code="editcontact.label.firstname" /></td>
				<td><form:input path="firstName" size="40" /><font
					color="#FF0000"><form:errors path="firstName" /></font></td>
			</tr>
			<tr>
				<td bgcolor="cyan"><spring:message
						code="editcontact.label.lastname" /></td>
				<td><form:input path="lastName" size="40" /><font
					color="#FF0000"><form:errors path="lastName" /></font></td>
			</tr>
			<tr>
				<td bgcolor="cyan"><spring:message code="editcontact.label.dob" /></td>
				<td><form:input path="dateOfBirth" size="40" /><font
					color="#FF0000"><form:errors path="dateOfBirth" /></font></td>
			</tr>
			<tr>
				<td bgcolor="cyan"><spring:message
						code="editcontact.label.married" /></td>
				<td><form:checkbox path="married" /><font color="#FF0000"><form:errors
							path="married" /></font></td>
			</tr>
			<tr>
				<td bgcolor="cyan"><spring:message
						code="editcontact.label.children" /></td>
				<td><form:input path="children" size="5" /><font
					color="#FF0000"><form:errors path="children" /></font></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<spring:message code="editcontact.button.save"/>" /></td>
				<td><input type="reset"
					value="<spring:message code="editcontact.button.reset"/>" /></td>
			</tr>
		</table>
		<a href="index.jsp"><spring:message
				code="editcontact.link.mainpage" /></a>
		<form:hidden path="id" />
	</form:form>
</body>
</html>