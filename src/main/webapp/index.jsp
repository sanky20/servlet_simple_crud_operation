<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	for (int i = 0; i < 5; i++) {
	%>

		<h5>Hi</h5>
		
		<h5 style="color: red;"> <% out.print(i); %>  </h5>
	
          <%= %>

	<%}%>

</body>
</html>