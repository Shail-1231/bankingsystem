<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="user_assets.jsp"></jsp:include>
<title>View ALl Transactions</title>
<style>
tr:nth-child(even) {
	background-color: #f2f2f2;
}

table {
  width: 100%;
}

th {
  height: 70px;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="user_left_side_bar.jsp"></jsp:include>

	<div class="container">
		<div class="content">

			<div class="item">
				<table border="1">
					<tr>
						<th>Transaction Id</th>
						<th>Type</th>
						<th>Amount</th>
						<th>Updated Balance</th>
					</tr>
					<c:forEach items="${transactions}" var="tra">
						<tr>
							<td>${tra.transactionId}</td>
							<td>${tra.transactionType}</td>
							<td>${tra.amount}</td>
							<td>${tra.updatedBalance}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>