<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create person</title>
</head>
<body>
	<div align="top">

		<form:form commandName="person" action="createPerson" method="POST">
			<table border="0">
				<tr>
					<td align="center"><h2>Registration</h2></td>
				</tr>
				<div align="left">
				<tr>
					<td>User Name:</td>
					<td><form:input path="firstName" tabindex="1" required="true" />
						<form:errors path="firstName" /></td>
				</tr>
				<br />
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" tabindex="2" required="true" />
						<form:errors path="lastName" /></td>
				</tr>
				<br />
				<tr>
					<td>Login:</td>
					<td><form:input path="login" tabindex="2" required="true" />
						<form:errors path="login" /></td>
				</tr>
				<br />
				<tr>
					<td>Password:</td>
					<td><form:input path="password" tabindex="2" required="true" />
						<form:errors path="password" /></td>
				</tr>
				<br />
				<tr>
					<td>Telephone:</td>
					<td><form:input path="telephone" tabindex="3" required="true" />
						<form:errors path="telephone" /></td>
				</tr>
				<br />
				<tr>
					<td>Street:</td>
					<td><form:input path="street" tabindex="4" required="true" />
						<form:errors path="street" /></td>
				</tr>
				<br />
				<tr>
					<td>City:</td>
					<td><form:input path="city" tabindex="5" required="true" /> <form:errors
							path="city" /></td>
				</tr>
				<br />
				<tr>
					<td>Zipcode:</td>
					<td><form:input path="zipcode" tabindex="6" required="true" />
						<form:errors path="zipcode" /></td>
				</tr>
				<br />
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="createPerson" /></td>
				</tr>
				</div>
			</table>
		</form:form>
	</div>
</body>
</html>