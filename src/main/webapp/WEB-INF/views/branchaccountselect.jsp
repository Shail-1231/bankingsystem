<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch Account Select</title>
</head>
<body>
	<h1>Branch and Account Selection</h1>
	<s:form action="branchaccountselect" method="post"
		modelAttribute="selection">
		<label for="accountType">Choose Account Type:</label>
		<select name="accountTypeId" id="typeaccount">
			<option value="-1">Choose Account Type</option>

			<c:forEach items="${accountType}" var="p">
				<option value="${p.accountTypeId}">${p.type}</option>
			</c:forEach>

		</select>
		<br>
		<br>

		<label for="branchSelect">Choose Branch :</label>
		<select name="branchId" id="typebranch">
			<option value="-1">Choose Branch</option>
			<c:forEach items="${branchSelect}" var="p">
				<option value="${p.branchId}">${p.branchName}</option>
			</c:forEach>

		</select>

		<br><br>
		<input type="submit" value="Submit">
	</s:form>



</body>
</html>