<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="user_assets.jsp"></jsp:include>
<title>View Account</title>
<style>
input[type=text] {
	word-wrap: break-word;
	word-break: break-all;
	height: 30px;
}
</style>
</head>
<body>
	<jsp:include page="user_left_side_bar.jsp"></jsp:include>

	<div class="container">
		<div class="content">

			<div class="item">
				<s:form modelAttribute="userBean">
					<p>
						Branch Id : <input type="text" value="${branch.branchId}" readonly>
					</p>
					<br>
					<br>
					<p>
						Branch Name : <input type="text" value="${branch.branchName}"
							readonly>
					</p>
					<br>
					<br>
					<p>
						Loan Interest Rate : <input type="text"
							value="${branch.loanIntRate}" readonly>
					</p>
					<br>
					<br>
					<p>
						Over draft limit : <input type="text"
							value="${branch.overDraftLimit}" readonly>
					</p>
				</s:form>


			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>