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
				<s:form action="deposit" method="post">
		Enter deposit amount : <input type="number" name="depositAmount">
					<input type="submit" value="Deposit Amount">
				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>