<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
     <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit a Donation</h1>
	<form:form action="/home/donation/process/edit/${donation.id}" 
	method="post" modelAttribute="donation">
	
<!-- <form:input path="donor" value="${donation.donor.id}"/> -->	
	<form:hidden path="donor"/>
	<input type="hidden" value="PATCH" name="_method"/>
		<div>
			<label path="donationName">Donation Name</label>
			<form:input type="text" path="donationName"/>
			<form:errors path="donationName"/>
		</div>
		<div>
			<form:label path="quantity">Quantity</form:label>
			<form:input type="text" path="quantity"/>
			<form:errors path="quantity"/>
		</div>
		<input class="btn btn-success" type="submit" value="Edit Donation"/>
	</form:form>
</body>
</html>