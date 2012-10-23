<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Flashcard Details</title>
</head>
<body>
	<h2>Flashcard Details for flashcard id: ${flashcard.id}</h2>
	<br />
	<br /> Go to
	<a href="<c:url value='/ihelp/card/cards' />">Flashcard Management</a>
	<br />
	<br />
	<form:form method="POST" action="/card/update"
		commandName="flashcard">
		<form:hidden path="id" />
		<label><spring:message code="label.topic" />:</label>
		<form:input path="topic" size="50" maxlength="50" />
		<br />
		<br />
		<label><spring:message code="label.question" />:</label>
		<form:input path="question" size="50" maxlength="50" />
		<br />
		<br />
		<label><spring:message code="label.answer" />:</label>
		<form:input path="answer" size="50" maxlength="50" />
		<br />
		<br />

		<button type="submit" name="submit">Save Update</button>
&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/ihelp/card/cards' />"> Cancel </a>

	</form:form>
</body>
</html>