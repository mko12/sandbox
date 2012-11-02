<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Flashcard Management</title>
    
    <!-- Include the bootstrap stylesheets -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
    
</head>
<body>
 
<h2>View and manage flashcards</h2>

<ul class="nav nav-pills">
  <li class="active"><a href="#">Flashcard Mgmt</a></li>
  <li><a href="<c:url value='/ihelp/user/users' />">User Mgmt</a></li>
  <li><a href="<c:url value='/ihelp/auth/logout' />">Logout</a></li>
</ul>

<br/>
 <h4>Logged in as: ${username}</h4>
<br />

<form:form method="post" action="add" commandName="flashcard" cssClass="form-horizontal">
  <div class="control-group">
    <form:label path="topic" cssClass="control-label"><spring:message code="label.topic"/></form:label>
    <div class="controls">
      <form:input path="topic" />
    </div>
  </div>
  <div class="control-group">
    <form:label path="question" cssClass="control-label"><spring:message code="label.question"/></form:label>
    <div class="controls">
      <form:input path="question" />
    </div>
  </div>
  <div class="control-group">
    <form:label path="answer" cssClass="control-label"><spring:message code="label.answer"/></form:label>
    <div class="controls">
      <form:input path="answer" />
    </div>
  </div>
  <div class="control-group">
    <form:label path="user" cssClass="control-label"><spring:message code="label.user"/></form:label>
    <div class="controls">
      <form:select path="user" items="${userList}" itemValue="userId"/>
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn"><spring:message code="label.addflashcard"/></button>
    </div>
  </div>
</form:form>
 

<h3>Flashcards</h3>
<c:if  test="${!empty flashcardList}">
<table class="table table-striped">
<tr>
    <th><spring:message code="label.topic"/></th>
    <th><spring:message code="label.question"/></th>
    <th><spring:message code="label.answer"/></th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${flashcardList}" var="card">
    <tr>
        <td>${card.topic}</td>
        <td>${card.question}</td>
        <td>${card.answer}</td>
        <td><a href="details/${card.id}">view details</a></td>
        <td><a href="delete/${card.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>