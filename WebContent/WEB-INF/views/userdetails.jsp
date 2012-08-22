<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Details</title>
</head>
<body>
 
<h2>User details for user with id: ${userId}</h2>

<%-- <form:form method="post" action="update.html" commandName="user">
    <table>
    <tr>
        <td><form:label path="username"><spring:message code="label.username"/></form:label></td>
        <td><form:input path="username" /></td>
    </tr>
    <tr>
        <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.updateuser"/>"/>
        </td>
    </tr>
	</table> 
</form:form>
 -->
 <!-- 
<table class="data">
<tr>
    <th><spring:message code="label.username"/>${user.username}</th>
    <th><spring:message code="label.password"/>${user.password}</th>
    <th><spring:message code="label.email"/>${user.email}</th>
    <th>&nbsp;</th>
</tr>
</table>
 --%>
<br/>
<a href="/user/users">Go back to User Management</a>
<br/>
</body>
</html>