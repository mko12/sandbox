<%@ include file="taglibs.jsp" %>

<html>
<head>
    <title>User Management</title>
</head>
<body>
 
<h2>View and manage users</h2>
<br/>
Go to <a href="<c:url value='/ihelp/card/cards' />">Flashcard Management</a>
<br/>
<br/>
<h3>Add a new user (should be replaced with a registration page really)</h3>
<br/>
<form:form method="post" action="add.html" commandName="user">
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
            <input type="submit" value="<spring:message code="label.adduser"/>"/>
        </td>
    </tr>
	</table> 
</form:form>
 
     
<h3>Users</h3>
<c:if  test="${!empty userList}">
<table class="data">
<tr>
    <th><spring:message code="label.username"/></th>
    <th><spring:message code="label.password"/></th>
    <th><spring:message code="label.email"/></th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${userList}" var="user">
    <tr>
    	<td>${user.username}</td>
    	<td>${user.password}</td>
        <td>${user.email}</td>
        <td><a href="details/${user.userId}">view details</a></td>
        <td><a href="delete/${user.userId}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>