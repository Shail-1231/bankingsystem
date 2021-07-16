<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
</head>
<body>
	Interest Amount :
	<input type="text" value="${interestamount}" readonly>
	<br>
	<br> EMI Amount :
	<input type="text" value="${emiamount}" readonly>
	<a href="dashboard">Return to Dashboard</a>
</body>
</html>