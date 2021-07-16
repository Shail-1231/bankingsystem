<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Branch Account Select</title>
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
	width: 400px;
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

.mainbox p {
	text-align: left;
	color: gray;
	margin: 0;
	padding-left: 30px;
	font-weight: bold;
	font-size: x-large;
}

select[name="accountTypeId"] {
	margin-left: 32px;
	margin-top: 10px;
	margin-bottom: 10px;
	display: inline-block;
	text-align: center;
	height: 25px;
	font-size: 20px;
	width: 258px;
}

select[name="branchId"] {
	margin-left: 32px;
	margin-top: 12px;
	margin-bottom: 20px;
	display: inline-block;
	text-align: center;
	height: 25px;
	font-size: 20px;
	width: 258px;
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
	margin-left: 30px;
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
</style>
</head>

<body>
	<div class="mainbox">

		<h1>Branch and Account Selection</h1>
		<s:form action="branchaccountselect" method="post"
			modelAttribute="selection">
			<p>
				<label for="accountType">Choose Account Type</label>
			</p>
			<select name="accountTypeId" id="typeaccount">
				<option value="-1">Choose Account Type</option>
				<c:forEach items="${accountType}" var="p">
                            `   <option value="${p.accountTypeId}">${p.type}</option>
				</c:forEach>

			</select>
			<p>
				<label for="branchSelect">Choose Branch </label>
			</p>
			<select name="branchId" id="typebranch">
				<option value="-1">Choose Branch</option>
				<c:forEach items="${branchSelect}" var="p">
					<option value="${p.branchId}">${p.branchName}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Submit">
		</s:form>

	</div>

</body>

</html>