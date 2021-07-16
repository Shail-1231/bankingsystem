<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Loan</title>
</head>
<body>
	<form action="depositloan" method="post">
		Enter your account number : <input type="text" name="accountnumber"><br><br>
		Enter the amount to be deposited into the loan : <input type="number" name="depositamount"><br>
		Enter the loan id in which you want to deposit : <input type="number" name="loanid"><br>
		<input type="submit" value="Deposit Loan">
	</form>
</body>
</html>