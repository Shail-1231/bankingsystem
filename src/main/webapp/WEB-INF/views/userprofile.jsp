<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>

	<h1>User Profile Creation</h1>
	<s:form action="userprofile" method="post"
		enctype="multipart/form-data" modelAttribute="userProfile">
		<label for="addressProofType">Choose Address Proof Type:</label>
		<select name="addressProofTypeId" id="type">
			<option value="-1">Choose Address Proof Type</option>

			<c:forEach items="${proofType}" var="p">
				<option value="${p.proofTypeId}">${p.proofTypeName }</option>
			</c:forEach>

		</select>
		<br>
		<br> Choose Address Proof : <input type="file"
			name="addressProofI">
		<br>
		<br> Choose Profile Picture :
		<input type="file" name="profilePictureI">
		<br>
		<br>
		Upload Pan Card : <input type="file" name="panPictureI">
		<br>
		<br> Pan Card Number : <input type="text" name="panNumber">
		<br>
		<br>
		<input type="submit" value="Create User Profile">
	</s:form>
</body>
</html>