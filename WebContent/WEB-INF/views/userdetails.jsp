<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Details</title>
</head>
<body>
	<h2>User details for user with id: ${userId}</h2>
	<br />
	<br /> Go to
	<a href="<c:url value='/ihelp/user/users' />">User Management</a>
	<br />
	<br />
	<form:form method="POST" action="/user/update"
		commandName="user">
		<form:hidden path="userId" />
		<label><spring:message code="label.username" />: ${user.username}</label>
		
		<br />
		<br />
		<label><spring:message code="label.password" />:</label>
		<form:input path="password" size="50" maxlength="50" />
		<br />
		<br />
		<label><spring:message code="label.email" />:</label>
		<form:input path="email" size="50" maxlength="50" />
		<br />
		<br />

		<button type="submit" name="submit">Save Update</button>
&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/ihelp/user/users' />"> Cancel </a>

	</form:form>
</body>
</html>