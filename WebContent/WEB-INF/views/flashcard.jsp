<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Flashcard Management</title>
</head>
<body>
 
<h2>Flashcard Manager</h2>
<br/>
 <h4>Logged in as: ${name}</h4>
 <br />
Go to <a href="<c:url value='/ihelp/user/users' />">User Management</a>
<br/>
 
<form:form method="post" action="/ihelp/card/add" commandName="flashcard">
 
    <table>
    <tr>
        <td><form:label path="topic"><spring:message code="label.topic"/></form:label></td>
        <td><form:input path="topic" /></td>
    </tr>
    <tr>
        <td><form:label path="question"><spring:message code="label.question"/></form:label></td>
        <td><form:input path="question" /></td>
    </tr>
    <tr>
        <td><form:label path="answer"><spring:message code="label.answer"/></form:label></td>
        <td><form:input path="answer" /></td>
    </tr>
    
    <tr>
        <td><form:label path="user"><spring:message code="label.user"/></form:label></td>
   		<td><form:select path="user" items="${userList}" itemValue="userId"/>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addflashcard"/>"/>
        </td>
    </tr>
</table> 
</form:form>

<h3>Flashcards</h3>
<c:if  test="${!empty flashcardList}">
<table class="data">
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