<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Amount</title>
</head>
<body>
	<s:form action="withdraw" method="post">
		Enter withdrawal amount : <input type="number" name="withdrawAmount">
		<input type="submit" value="Withdraw Amount">
	</s:form>
</body>
</html>