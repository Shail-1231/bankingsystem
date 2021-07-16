<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
body {
	margin: 0;
	background-color: rgb(95, 87, 87);
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

.welcomebox {
	width: 300px;
	height: 300px;
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

button {
	display: inline-block;
	background-color: lightblue;
	border-radius: 10px;
	border: 4px double #cccccc;
	color: #eeeeee;
	text-align: center;
	font-size: 28px;
	padding: 20px;
	width: 258px;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	-o-transition: all 0.5s;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

button:hover {
	cursor: pointer;
	background-color: rgb(52, 168, 207);
	font-size: 30;
	font-weight: bold;
}
</style>
</head>

<body>
	<div class="welcomebox">

		<h1>Welcome To Bank Management System</h1>
		<form class="frm">
			<button formaction="signuppage">Sign Up</button>
			<button formaction="loginpage">Login</button>
		</form>
	</div>


</body>

</html>