<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>User Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${user}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName }</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
				<td><a href="request">Make a Request</a>
				<td><a href="transfer">Make a Transfer</a>
				<td><a href="viewaccount/${user.userId}">View My Account</a>
				<td><a href="updateprofile/${user.userId}">Update Profile</a>
				<td><a href="changepassword">Change Password</a>
				<td><a href="deposit">Deposit Amount</a>
				<td><a href="withdraw">Withdraw Amount</a>
				<td><a href="logout/${user.userId}">Logout</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>