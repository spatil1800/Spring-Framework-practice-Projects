<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spizza</title>
</head>
<body>

			<body>
		<h2>Welcome to Spizza!!!</h2>
		<form:form>
		<input type="hidden" name="_flowExecutionKey"
		value="${flowExecutionKey}"/>
		<input type="text" name="PhoneNo"/><br/>
		<input type="submit" name="_eventId_phoneEntered"
		value="Lookup Customer" />
		</form:form>
		</body>
</body>
</body>
</html>