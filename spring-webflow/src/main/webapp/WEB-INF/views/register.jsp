<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer Registration</h2>
	<form:form commandName="customer">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<b>Phone number: </b>
		<form:input path="phoneNo" />
		<br />
		<b>Name: </b>
		<form:input path="name" />
		<br />
		<b>Address: </b>
		<form:input path="address" />
		<br />
		<b>City: </b>
		<form:input path="city" />
		<br />
		<b>State: </b>
		<form:input path="state" />
		<br />
		<b>Zip Code: </b>
		<form:input path="pincode" />
		<br />
		<input type="submit" name="_eventId_submit" value="Submit" />
		<input type="submit" name="_eventId_cancel" value="Cancel" />
	</form:form>
</body>
</html>