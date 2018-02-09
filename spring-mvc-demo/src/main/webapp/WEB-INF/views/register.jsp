<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style type="text/css">
	span.error {
color: red;
}
</style>
</head>
<body>
	
			<sf:form method="POST" commandName="user" enctype="multipart/form-data">
		Name: <sf:input path="name" />
		<sf:errors path="name" cssClass="error" /><br/>
		Email: <sf:input path="email" />
		<sf:errors path="email" cssClass="error" /><br/>
		Mobile: <sf:input path="number" />
		<sf:errors path="number" cssClass="error" /><br/>
		Profile Pic: <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
		<input type="submit" value="Register" />
		</sf:form>
</body>
</html>