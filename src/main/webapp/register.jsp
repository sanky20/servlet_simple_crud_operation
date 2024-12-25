<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
fieldset {
	width: 300px;
}
</style>
</head>
<body>

	<form action="userRegister" method="get">
		<fieldset >
			<legend align="center">Registration Form</legend>

			<br> <br> 
			<label for="userId">UserId</label> 
			<input
				type="number" placeholder="enter your id" name="userId" id="userId">
			<br><br> 
			<label for="userName" >UserName</label> 
			<input type="text"
				placeholder="enter your name" name="userName" id="userName">
		    <br><br> 
		    <label for="userEmail">Email</label> <input type="email"
				placeholder="enter your email" name="userEmail" id="userEmail"> <br>
			<br>
			<label for="userPassword">Password</label>
			<input type="password" id="userPassword" name="userPassword" > <br> <br>
			 <label for="userDOB">userDOB</label> 
			<input type="date"
				placeholder="enter your DOB" name="userDOB" id="userDOB"> <br>
			<br> 
			    <label>User Gender: </label><br>
		        <input type="radio" name="gender" value="male" id="male">
		        <label for="male">Male</label>
		        <input type="radio" name="gender" value="female" id="female">
		        <label for="female">Female</label>
                      <br> <br>
			<input type="submit" value="register" >


		</fieldset>
	</form>

</body>
</html>