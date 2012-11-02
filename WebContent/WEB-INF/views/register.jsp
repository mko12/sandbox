<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Include the bootstrap stylesheets -->
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flashcard App - Register</title>
</head>
<body>

<h1>FlashApp - Registration Page</h1>

<div id="login-error">${error}</div>

<form:form method="post" action="../user/add.html" commandName="user" class="well span4">
    <table>
    <tr>
        <td><form:label path="username"><spring:message code="label.username"/></form:label></td>
        <td><form:input path="username" class="span3"/></td>
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:input path="password" class="span3"/></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" class="span3"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.registeruser"/>" class="btn btn-primary"/>
            <a href="<c:url value='/ihelp/auth/logout' />" class="btn"> Back to Login </a>
        </td>
    </tr>
	</table> 
</form:form>

</body>
</html>