<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Amount</title>
</head>
<body>
 	<s:form>
 		Enter account number to which you want to transfer the funds : <input type="text" name="accountNumber"><br><br>
 		Enter the amount to be transferred : <input type="number" name="transferAmount">
 		<br><br>
 		<input type="submit" value="Transfer Amount">
 		
 	</s:form>
</body>
</html>