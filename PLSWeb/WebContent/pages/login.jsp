<%@ include file="taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

</head>
<body class="loginPage">
	<div class="mainBox">
		<img id="logo" src="${pageContext.request.contextPath}/img/Official_Pointwest_Logo_Pantone (299, 151).png" />
		<h3>People Locator System</h3>
		<div class="loginContainer">
			<form method="post" action="Login">
				<label class="floatLeft"> Username:</label> 
				<input type="text" name="username" id="inputEmail" class="textBox floatRight" placeholder="Username" required />
				<div class="clear"></div>
				<label class="floatLeft"> Password:</label>
				<input type="password" name="password" class="textBox floatRight" placeholder="Password" required />
				<div class="clear"></div>
				<div id="errorMessage">${ error }</div>
				<button class="btn btn-submit floatRight" type="submit">Login</button>
				<div class="clear"></div>
			</form>
		</div>
	</div>
</body>
</html>