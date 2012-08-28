<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Flashcard Details</title>
</head>
<body>
 
<h2>Flashcard Details for flashcard with id: ${cardId}</h2>
<a href="../card/cards">Go to Flashcard Management</a>
<br/>
<h3>
    <spring:message code="label.topic"/>${flashcard.topic}
    <spring:message code="label.question"/>${flashcard.question}
    <spring:message code="label.answer"/>${flashcard.answer}
</h3>
 
</body>
</html>