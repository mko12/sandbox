<%@ include file="taglibs.jsp" %>

<html>
<head>
<title>Login to Application</title>
</head>
<body>
	<h2>Please enter your login information:</h2>
	<form:form method="post" action="login.html" commandName="user">
	<table>
    <tr>
        <td>
		<form:label path="username">
			<spring:message code="label.username" />
		</form:label></td>
		<td>
		<form:input path="username" /></td>
	</tr>
	<tr>
		<td>
		<form:label path="password">
			<spring:message code="label.password" />
		</form:label></td>
		<td>
		<form:input path="password" /></td>
	</tr>
	<tr>	
		<td></td>
		<td>			
		<input type="checkbox" name="rememberMe" id="rememberMe"/>
	    <label for="rememberMe" style="vertical-align: top">Remember Me</label></td>
	</tr>
	</table>
	
	<input type="submit" value="<spring:message code="label.login"/>" />
			
	</form:form>

	<br/>
	<br/> Go to
	<a href="card/cards">Flashcard Management</a>
	<br />
	<br /> Go to
	<a href="user/users">User Management</a>
</body>
</html>