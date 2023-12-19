<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create a new user</h1>
	<form:form action="/home/user/process/create" modelAttribute="user">
		<div>
			<label>User Name</label>
			<form:input type="text" path="userName"/>
			<form:errors path="userName"/>
		</div>
		<div>
			<form:label path="email">Email</form:label>
			<form:input type="text" path="email"/>
			<form:errors path="email"/>
		</div>
		<input type="submit" value="Create User"/>
	</form:form>
</body>
</html>