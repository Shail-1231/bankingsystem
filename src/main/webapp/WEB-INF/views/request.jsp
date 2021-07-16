<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="user_assets.jsp"></jsp:include>
<title>Deposit into Account</title>
</head>
<body>
	<jsp:include page="user_left_side_bar.jsp"></jsp:include>

	<div class="container">
		<div class="content">

			<div class="item">
				<form action="request" method="post">


					<p><label for="request">Select your request:</label> <select
						name="request">
						<option value="loan">Apply for Loan</option>
						<option value="overdraft">Apply for overdraft increase</option>
						<option value="changebranch">Apply for change of branch</option>
					</select> <br><br><input type="submit" value="Submit request"></p>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>