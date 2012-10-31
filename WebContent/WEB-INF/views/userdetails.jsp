<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <!-- Include the bootstrap stylesheets -->
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>

<title>User Details</title>
</head>
<body>
	<h2>User details for user with id: ${userId}</h2>
	<br />
	<br /> Go to
	<a href="<c:url value='/ihelp/user/users' />">User Management</a>
	<br />
	<br />
	<form:form method="post" action="../update" commandName="user" class="well span4">
		<form:hidden path="userId" />
		<label><spring:message code="label.username" />: ${user.username}</label>
		<form:hidden path="username" />
		<br />
		<br />
		<label><spring:message code="label.password" />:</label>
		<form:input path="password" class="span3" />
		<br />
		<br />
		<label><spring:message code="label.email" />:</label>
		<form:input path="email" class="span3" />
		<br />
		<br />
		<input type="submit" value="<spring:message code="label.update"/>" class="btn btn-primary"/>
		&nbsp;&nbsp;&nbsp;
		<a href="<c:url value='/ihelp/user/users' />" class="btn"> Cancel </a>

	</form:form>
</body>
</html>