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
				<form action="changebranch" method="post">


		<label for="changebranch">Select your new branch:</label> <select
			name="changebranch">
			<option value="Paldi">Paldi</option>
			<option value="Kathwada">Kathwada</option>
			<option value="Bopal">Bopal</option>
			<option value="Prahladnagar">Prahladnagar</option>
		</select> <input type="submit" value="Change Branch">
	</form>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>