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
	<title>Flashcard App - Register</title>
</head>
<body>

<h1>FlashApp - Register</h1>

<div id="login-error">${error}</div>

<div id="registerDiv" class="container">


	<form method="post" action="../user/add.html" commandName="user" class="well span4">
		<h2 class="form-signin-heading">Please register</h2>
		<p>
	        <label path="username"><spring:message code="label.username"/></label>
	        <input path="username" class="span3"/>
	    </p>
		<p>
	        <label path="password"><spring:message code="label.password"/></label>
	        <input path="password" class="span3"/>
	    </p>
		<p>
	        <label path="email"><spring:message code="label.email"/></label>
	        <input path="email" class="span3"/>
	   </p>
	        <input type="submit" value="<spring:message code="label.registeruser"/>" class="btn btn-primary"/>
	            <a href="<c:url value='/ihelp/auth/logout' />" class="btn"> Back to Login </a>
	</form>
</div>

</body>
</html>