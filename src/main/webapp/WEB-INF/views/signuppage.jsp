<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>
	<h1>Sign Up Page</h1>
	<s:form action="signuppage" method="post" modelAttribute="userInfo">
		First Name : <input type="text" name="firstName">
		<br>
		<br>
		Last Name : <input type="text" name="lastName">
		<br>
		<br>
		Email : <input type="email" name="email">
		<br>
		<br>
		Password : <input type="password" name="password">
		<br>
		<br>
		Address : <input type="text" name="address">
		<br>
		<br>
		<input type="hidden" name="roleId" value=2>
		<input type="submit" value="Sign Up">
	</s:form>
</body>
</html>