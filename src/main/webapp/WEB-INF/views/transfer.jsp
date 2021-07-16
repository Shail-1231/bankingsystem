<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="user_assets.jsp"></jsp:include>
<title>Transfer funds</title>
</head>
<body>
	<jsp:include page="user_left_side_bar.jsp"></jsp:include>

	<div class="container">
		<div class="content">

			<div class="item">
				<s:form>
					<p>Enter account number to which you want to transfer the funds
						:</p>
					<input type="text" name="accountNumber">
					<br>
					<br>
					<p>
						Enter the amount to be transferred : <input type="number"
							name="transferAmount"> <br> <br> <input
							type="submit" value="Transfer Amount">

					</p>
				</s:form>
				<a href="depositloan">Transfer Amount to Loan</a>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>