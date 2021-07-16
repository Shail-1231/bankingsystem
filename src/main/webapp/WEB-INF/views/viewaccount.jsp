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
						First Name : <input type="text" value="${userBean.firstName }"
							readonly>
					</p>
					<br>
					<br>
					<p>
						Last Name : <input type="text" value="${userBean.lastName }"
							readonly>
					</p>
					<br>
					<br>
					<p>
						Email : <input type="text" value="${userBean.email }" readonly>
					</p>
					<br>
					<br>
				</s:form>

				<s:form modelAttribute="accountBean">
					<p>
						Account Number : <input type="text"
							value="${accountBean.accountNumber }" readonly>
					</p>
					<br>
					<br>
					<p>
						Balance : <input type="text" value="Rs.${accountBean.balance }"
							readonly>
					</p>
					<br>
					<br>
				</s:form>

				<s:form modelAttribute="branchBean">
					<p>
						Branch Name : <input type="text" value="${branchBean.branchName }"
							readonly>
					</p>
					<br>
					<br>
				</s:form>

				<p>
					<a href="viewtransaction">View My Transactions</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="user_footer.jsp"></jsp:include>
</body>
</html>