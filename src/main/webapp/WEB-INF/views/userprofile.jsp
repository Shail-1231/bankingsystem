<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style>
body {
	margin: 0;
	background-color: rgb(192, 144, 144);
	background-size: cover;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

* {
	box-sizing: border-box;
}

.main {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50, -50);
}

.mainbox {
	width: 500px;
	height: 600px;
	background: rgb(248, 248, 248);
	color: #ffff;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	position: absolute;
	box-sizing: border-box;
	border-radius: 15px;
	padding: 15px 15px;
	margin: 0;
}

h1 {
	color: gray;
	text-align: center;
	margin: 0%;
	font-size: 26px;
	padding: 0 0 20px;
}

.mainbox p {
	text-align: left;
	color: gray;
	margin: 0;
	padding-left: 20px;
	font-weight: bold;
	font-size: x-large;
}

.mainbox input[type="file"] {
	display: inline-block;
	color: gray;
	text-align: center;
	font-size: 22px;
	padding-top: 10px;
	padding-left: 20px;
	padding-bottom: 20px;
	width: 400px;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	-o-transition: all 0.5s;
	transition: all 0.5s;
	cursor: pointer;
}

.dropdown {
	width: 470px;
	padding: 20px;
	height: 30px;
	margin-bottom: 0px;
	align-self: center;
	border-color: #000;
	border: 35px;
	padding-left: 25px;
	text-align: justify;
	background: darkgray;
	height: 32px;
	font-size: 20px;
	border-radius: 5px;
	margin: 0;
}

.mainbox input[type="text"] {
	width: 400px;
	height: 30px;
	align-self: center;
	border-color: #000;
	border: 35px;
	text-align: justify;
	background: darkgray;
	height: 32px;
	font-size: 20px;
	border-radius: 5px;
	margin-left: 20px;
}

.mainbox input[type="submit"] {
	border: none;
	margin-top: -12 px;
	display: in;
	outline: none;
	width: 300px;
	height: 55px;
	background: lightblue;
	color: #fff;
	text-align: center;
	font-size: x-large;
	line-height: 0px;
	border-radius: 7px;
	align-items: center;
	margin-left: 85px;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	-o-transition: all 0.5s;
	transition: all 0.5s;
	cursor: pointer;
}

.mainbox input[type="submit"]:hover {
	cursor: pointer;
	background-color: rgb(52, 168, 207);
	font-size: 24;
	font-weight: bold;
}

select[name="addressProofTypeId"] {
	margin-left: 20px;
	margin-top: 10px;
	margin-bottom: 10px;
	display: inline-block;
	text-align: center;
	height: 25px;
	font-size: 20px;
	width: 258px;
}
</style>
</head>

<body>
	<div class="mainbox">
		<h1>User Profile Creation</h1>
		<s:form action="userprofile" method="post"
			enctype="multipart/form-data" modelAttribute="userProfile">
			<p>
				<label for="addressProofType">Choose Address Proof Type</label>
			</p>

			<select name="addressProofTypeId" id="type">
				<option value="-1">Choose Address Proof Type</option>

				<c:forEach items="${proofType}" var="p">
					<option value="${p.proofTypeId}">${p.proofTypeName }</option>
				</c:forEach>

			</select>
			<p>Choose Address Proof</p>
			<input type="file" name="addressProofI">
			<p>Choose Profile Picture</p>
			<input type="file" name="profilePictureI">
			<p>Upload Pan Card</p>
			<input type="file" name="panPictureI">
			<p>Pan Card Number</p>
			<input type="text" name="panNumber">
			<br>
			<br>
			<input type="submit" value="Create User Profile">
		</s:form>
	</div>
</body>

</html>