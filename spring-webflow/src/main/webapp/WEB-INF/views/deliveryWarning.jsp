<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Delivery Unavailable</h2>
	<p>The address is outside of our delivery area. You may still place
		the order, but you will need to pick it up yourself.</p>

	<a href="${flowExecutionUrl}&_eventId=accept"> Continue, I'll pick
		up the order</a> |
	<a href="${flowExecutionUrl}&_eventId=cancel">Never mind</a>

</body>
</html>