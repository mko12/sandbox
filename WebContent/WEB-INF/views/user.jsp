<%@ include file="taglibs.jsp" %>

<html>
<head>
   <!-- Include the bootstrap stylesheet -->
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>
    <title>User Management</title>
</head>
<body>
 <ul class="nav nav-pills">
 	 <li><a href="<c:url value='/ihelp/card/cards' />">Flashcard Mgmt</a></li>
 	 <li class="active"><a href="#">User Mgmt</a></li>
 	 <li><a href="<c:url value='/ihelp/auth/logout' />">Logout</a></li>
 </ul>
<h4>Logged in as: ${username}</h4>
<h2>View and manage users</h2>

<br/>
<h3>Users</h3>
<c:if  test="${!empty userList}">
<table class="table table-striped">
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
        <td><a href="delete/${user.userId}"> delete</a></td>
        <td><a href="json/${user.userId}">Get JSON</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>