<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>House Hunter Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class = "container">
<h1>Welcome, <c:out value="${user.userName }"/>!</h1>
<a href="/logout"> Log Out </a>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Address</th>
			<th>Listed On</th>
			<th>Added By</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="eachListing" items="${allListings }">
			<tr>
				<td> <a href="/view/${eachListing.id }"><c:out value="${eachListing.address }"/></a> </td>
				<td><fmt:formatDate type = "date" value = "${eachListing.createdAt }" /></td>
				<td><c:out value="${eachListing.user.userName}"/></td>
				<td>$<c:out value="${String.format('%.2f',eachListing.price)}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/listing/new" class="btn btn-success">Add Listing</a>


</body>
</html>




