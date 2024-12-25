<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <style>
    fieldset{
       width: 450px;
    }
  </style>
<body>

	<%
	String message = (String) request.getAttribute("msg");

	if (message != null) {
	%>
	<h4 style="color: red;"><%=message%></h4>

	<%
	}
	%>

	<form action="loginUser" method="get">
		<fieldset>
		  <legend align="center">Login Form</legend>
			<label>Email: </label> <input type="email"
				placeholder="enter your email" name="userEmail"> <br> <br>
			<label>Password: </label> <input
				type="password" placeholder="enter your password" name="password"><br>
			<br> <input type="submit" value="LOGIN">
		</fieldset>
	</form>


</body>
</html>