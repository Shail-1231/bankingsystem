<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request for money transfer</title>
</head>
<body>
	<s:form action="request" method="post">
		Enter the account to which you want to transfer the funds : <input type="text" name="accountNumber">
		Enter the money to be transferred : <input type="number" name="transferFund">
		<input type="submit" value="Tranfer Fund">  
	
	</s:form>
</body>
</html>