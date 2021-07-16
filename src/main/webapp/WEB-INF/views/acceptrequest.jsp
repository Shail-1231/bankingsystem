<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Accept Page</title>
</head>
<body>
	<form action="acceptrequest" method="post" >
		Change Branch To : <input type="text" name="changebranch"><br><br>
		<input type="hidden" value="${request.userId }" name="userid">
		<input type="submit" value="Change Branch">
	</form>
</body>
</html>