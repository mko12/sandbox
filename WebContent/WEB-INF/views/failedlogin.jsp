<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login to Application Failed</title>
</head>
<body>

	<h2>Login Failed</h2>

	<br />
	<h4>Could not login as: ${name}</h4>
	<h5>due to: ${loginStatus}</h5>

	<br /> Back to the
	<a href="login">login page</a>
	<br />
	<br /> Go to
	<a href="/card/cards">Flashcard Management</a>
	<br />
	<br /> Go to
	<a href="/user/users">User Management</a>
</body>
</html>