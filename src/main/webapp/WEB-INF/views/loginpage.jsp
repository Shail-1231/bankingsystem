<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<style>
body {
	margin: 0%;
	padding: 0%;
	background-color: rgb(192, 144, 144);
	background-position: center;
	background-size: cover;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.loginbox {
	width: 350px;
	height: 320px;
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
	font-size: xx-large;
	padding: 0 0 20px;
}

.loginbox p {
	text-align: left;
	color: gray;
	margin: 0;
	padding-left: 20px;
	font-weight: bold;
	font-size: x-large;
}

.loginbox input {
	width: 270px;
	padding: 10px;
	height: 30px;
	margin-bottom: 0px;
	align-self: center;
}

.loginbox input[type="email"], input[name="email"] {
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

.loginbox input[type="password"], input[name="password"] {
	border-color: #000000;
	border: 35px;
	padding-left: 25px;
	text-align: justify;
	background: darkgray;
	height: 32px;
	border-radius: 5px;
	font-size: 20px;
}

.loginbox input[type="submit"] {
	border: none;
	outline: none;
	height: 40px;
	margin-top: 10px;
	margin-left: 27px; background : lightblue;
	color: #fff;
	text-align: center;
	line-height: 0px;
	font-size: medium;
	border-radius: 7px;
	background: lightblue;
}

.loginbox input[type="submit"] :hover {
	cursor: pointer;
	background: #ffc107;
	color: #000;
}
</style>
</head>

<body>
	<form action="loginpage" method="post">

		<div class="loginbox">
			<h1>Login here</h1>
			<form>
				<p>Email</p>
				<input type="email" name="email" placeholder="enter email"><br>
				<p>Password</p>
				<input type="password" name="password" placeholder="enter password">
				<br> <input type="submit" name="Login">
			</form>
		</div>
	</form>
</body>


</html>