<%@page import="com.tcs.servlet_simple_crud_operation.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display-Page</title>
</head>
<body>
	<h4>Display-Page</h4>


	<%
	List<User> users = new UserDao().getAllUserDao();
	%>

	<table border="2" rules="all" cellpadding="20px" >
	
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>DOB</th>
			<th>Gender</th>
			<th colspan="2">Action</th>

		</tr>

		<%
		for (User user : users) {
		%>
		<tr>
			<td><%=user.getId() %> </td>
			<td> <%=user.getName() %> </td>
			<td><%=user.getEmail() %></td>
			<td><%=user.getDob() %></td>
			<td><%=user.getGender() %></td>
			<td> <a href="delete?id=<%=user.getId()%>"> DELETE </a> </td>
			<td> <a href="edit.jsp?id=<%=user.getId()%>">EDIT</a> </td>

		</tr>
		<%
		}
		%>
	</table>
	<br><br>
	<a href="register.jsp">Register Page</a>


</body>
</html>