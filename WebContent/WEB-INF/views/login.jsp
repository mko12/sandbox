<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login to Application</title>
</head>
<body>

	<h2>Welcome to our app</h2>

	<form:form method="post" action="login.html" commandName="user">
		<table>
			<tr>
				<td><form:label path="username">
						<spring:message code="label.username" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message code="label.password" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.login"/>" /></td>
			</tr>
		</table>
	</form:form>

	<br />
	<br /> Go to
	<a href="/card/cards">Flashcard Management</a>
	<br />
	<br /> Go to
	<a href="/user/users">User Management</a>
</body>
</html>