<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Include the bootstrap stylesheets -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Flashcard App - Login</title>
</head>
<body>

<h1>FlashApp - Login</h1>

<div id="login-error">${error}</div>

<div id="loginDiv" class="container">
	
	<form class="well span4" action="../../j_spring_security_check" method="post" >
	<h2 class="form-signin-heading">Please sign in</h2>
	<p>
		<label for="j_username">Username</label>
		<input id="j_username" name="j_username" type="text" class="span3"/>
	</p>
	<p>
		<label for="j_password">Password</label>
		<input id="j_password" name="j_password" type="password" class="span3"/>
	</p>
	
	<input type="submit" value="<spring:message code="label.loginuser"/>" class="btn btn-primary"/>
	<a href="<c:url value='/ihelp/auth/register' />" class="btn"> <spring:message code="label.registeruser"/></a>
	</form>
</div>

</body>
</html>