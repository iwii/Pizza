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
	<h1>Add new Person</h1>

	<form:form commandName="person" action="createPerson"	method="POST">

		<form:input path="firstName" />
		<br />
		<form:input path="lastName" />
		<br />
		<form:input path="telephone" />
		<br />
		<form:input path="street" />
		<br />
		<form:input path="city" />
		<br />
		<form:input path="zipcode" />
		<br />

		<input type="submit" value="createPerson" />
	</form:form>
</body>
</html>