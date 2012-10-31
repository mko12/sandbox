<%@ include file="taglibs.jsp" %>

<html>
<head>
   <!-- Include the bootstrap stylesheet -->
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>

    <title>User Management</title>
</head>
<body>
 
<h2>View and manage users</h2>
<a href="<c:url value='/ihelp/auth/logout' />"> Logout </a>
<br/>
<br/>
Go to <a href="<c:url value='/ihelp/card/cards' />">Flashcard Management</a>
<br/>
<br/>

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
        <td><a href="details/${user.userId}" class="btn">view details</a></td> 
        <td>|</td>
        <td><a href="delete/${user.userId}" class="btn">delete</a></td> 
        <td>|</td>
        <td><a href="json/${user.userId}" class="btn">Get JSON</a></td>
        <td>|</td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>