<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
<h1>Create a Donation</h1>
	<form:form action="/home/donation/process/create" modelAttribute="donation">
		<div>
			<label>Donation Name</label>
			<form:input type="text" path="donationName"/>
			<form:errors path="donationName"/>
		</div>
		<div>
			<form:label path="quantity">Quantity</form:label>
			<form:input type="text" path="quantity"/>
			<form:errors path="quantity"/>
		</div>

			<form:label path="donor">Donor</form:label>
			<form:select path="donor"> 
				<c:forEach var="user" items="${allUsers}">
					<form:option value="${user.id}" path="donor">
						<c:out value="${user.userName}"/>
					</form:option>
				</c:forEach>
			</form:select>
		<input class="btn btn-success" type="submit" value="Create Donation"/>
	</form:form>
</body>
</html>