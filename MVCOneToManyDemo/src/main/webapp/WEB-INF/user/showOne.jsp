<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Donor name: <c:out value="${user.userName}"/></h1>
	<h2>Donor email: <c:out value="${user.email}"/></h2>
	<table class="table table-dark">
    <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Donation name</th>
            <th scope="col">Quantity</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${user.donations}" var="donation">
        <tr>
            <td><c:out value="${donation.id}"/></td>
            <td><c:out value="${donation.donationName}"/></td>
            <td><c:out value="${donation.quantity}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>