<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<h1>Welcome To Spring MVC DEMO</h1>
<h2>Name: ${user.name }</h2>
<h2>Email: ${user.email }</h2>
<h2>Mobile Number: ${user.number }</h2>
<h2>${user }</h2>
</body>
</html>