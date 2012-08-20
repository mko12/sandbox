<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management</title>
</head>
<body>
 
<h2>User Manager</h2>
<a href="cards">Go to Flashcard Management</a>
<br/>
<form:form method="post" action="adduser.html" commandName="user">
 
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
    <th>Username</th>
    <th>Email</th>
    <th>Password</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${userList}" var="user">
    <tr>
    	<td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>
        <td><a href="updateuser/${user.id}">Update</a></td>
        <td><a href="deleteuser/${user.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>