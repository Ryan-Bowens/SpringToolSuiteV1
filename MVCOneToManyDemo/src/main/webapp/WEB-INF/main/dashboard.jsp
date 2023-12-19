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
<title>Insert title here</title>
</head>
<body>
	<h1>DashBoard</h1>
	
	<a href="/home/user/create" class="btn btn-success">Create User</a>
	<a href="/home/donation/create" class="btn btn-primary">Add Donation</a>
	
	<h2>All donations</h2>
	<table class="table table-dark">
    <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Donation name</th>
            <th scope="col">Quantity</th>
            <th scope="col">Donor</th>
            <th scope="col">Number of donations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allDonations}" var="donation">
        <tr>
            <td><c:out value="${donation.id}"/></td>
            <td><c:out value="${donation.donationName}"/></td>
            <td><c:out value="${donation.quantity}"/></td>
            <td><c:out value="${donation.donor.userName}"/></td>
            <td><a class="btn btn-outline-warning" href="/home/donation/edit/${donation.id}">Edit</a>
            <form action="/home/donation/delete/${donation.id}" method="POST">
            	<input type="hidden" value="DELETE" name="_method"/>
            	<input type="submit" value="Delete" class="btn btn-outline-danger"/>
            </form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	<h2>All Users</h2>
	<table class="table table-dark">
    <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">User name</th>
            <th scope="col">Email</th>
            <th scope="col">Number of donations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allUsers}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><a href="/home/user/display/${user.id}"><c:out value="${user.userName}"/></a></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.donations.size()}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>