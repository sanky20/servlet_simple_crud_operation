<%@page import="com.tcs.servlet_simple_crud_operation.entity.User"%>
<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>

	<%
	int id = Integer.parseInt(request.getParameter("id"));

	User user = new UserDao().getUserByIdDao(id);
	%>

	<form action="userUpdate" method="get">
		<fieldset>
			<legend align="center">Edit Form</legend>

			<br> <br> <label for="userId">UserId</label> <input
				type="number" name="userId" id="userId" value="<%=user.getId()%>">
			<br> <br> <label for="userName">UserName</label> <input
				type="text" name="userName" id="userName"
				value="<%=user.getName()%>"> <br> <br> <label
				for="userEmail">Email</label> <input type="email" name="userEmail"
				id="userEmail" value="<%=user.getEmail()%>"> <br> <br>
			<label for="userPassword">Password</label> <input type="password"
				id="userPassword" name="userPassword"
				value="<%=user.getPassword()%>"> <br> <br> <label
				for="userDOB">userDOB</label> <input type="date" name="userDOB"
				id="userDOB" value="<%=user.getDob()%>"> <br> <br>
			<label>User Gender: </label><br> <input type="radio"
				name="gender" value="Male" id="male"
				<%if (user.getGender().equalsIgnoreCase("male")) {%>
				checked="checked" <%}%>> <label for="male">Male</label> <input
				type="radio" name="gender" value="Female" id="female"
				<%if (user.getGender().equalsIgnoreCase("female")) {%>
				checked="checked" <%}%>>  <label for="female">Female</label>
			<br> <br> <input type="submit" value="update">


		</fieldset>
	</form>

</body>
</html>