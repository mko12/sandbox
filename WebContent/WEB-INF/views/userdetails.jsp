<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Details</title>
</head>
<body>
	<h2>User details for user with id: ${userId}</h2>

	<form:form method="POST" action="/user/update">
		<c:if test="${!empty user}">
			<table width="100%" cellspacing="3" cellpadding="3" border=0>
				<tr>
					<td><spring:message code="label.username" /></td>
					<%--		<td><input type="text" name="name" value="${user.username}" /></td>
		 --%>
				</tr>
				<tr>
					<td><spring:message code="label.password" /></td>
					<%--		<td><input type="text" name="name" value="${user.username}" /></td>
		 --%>
				</tr>
				<tr>
					<td><spring:message code="label.email" /></td>
					<%--		<td><input type="text" name="name" value="${user.username}" /></td>
		 --%>
				</tr>
				<tr>
					<td><br />
						<div class="buttons">
							<button type=submit name="submit">Save</button>
							<a href="<c:url value='/user/users' />"> Cancel </a>
						</div></td>
				</tr>
			</table>
		</c:if>
		<h3>
			is it empty?
			<c:out value="${user}" />
			end
		</h3>
	</form:form>
</body>
</html>