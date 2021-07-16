<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
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

.signupbox {
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

.signupbox input[type="submit"] {
	border: none;
	display: in;
	outline: none;
	width: 200px;
	height: 50px;
	background: lightblue;
	color: #fff;
	text-align: center;
	font-size: xx-large;
	line-height: 0px;
	font-size: xx-large;
	border-radius: 7px;
	align-items: center;
	margin-left: 140px;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	-o-transition: all 0.5s;
	transition: all 0.5s;
	cursor: pointer;
}

.signupbox input[type="submit"]:hover {
	cursor: pointer;
	background-color: rgb(52, 168, 207);
	font-size: 36;
	font-weight: bold;
}

.signupbox p {
	text-align: left;
	color: gray;
	margin: 0;
	padding-left: 20px;
	font-weight: bold;
	font-size: 23px;
}

.signupbox input[type="text"], [type="email"], [type="password"] {
	width: 418px;
	
	margin-top: 10px;
	margin-left: 20px;
	margin-bottom: 20px;
	height: 25px;
	align-self: center;
	border-color: #000;
	border: 35px;
	display: inline-block;
	text-align: justify;
	background: darkgray;
	height: 32px;
	font-size: 20px;
	border-radius: 5px;
}
</style>
</head>

<body>

	<div class="signupbox">
		<h1>Sign Up Page</h1>
		<s:form action="signuppage" method="post" modelAttribute="userInfo">
			<p>First Name</p>
			<s:input path="firstName" />
			<p>Last Name</p>
			<s:input path="lastName" />
			<p>Email</p>
			<s:input path="email" />
			<p>Password</p>
			<input type="password" name="password">
			<p>Address</p>
			<input type="text" value="${userInfo.address}" name="address">
			<br>
			<input type="hidden" name="roleId" value=2>
			<input type="submit" value="Sign Up">
		</s:form>
	</div>
	<br> ${message }
</body>

</html>