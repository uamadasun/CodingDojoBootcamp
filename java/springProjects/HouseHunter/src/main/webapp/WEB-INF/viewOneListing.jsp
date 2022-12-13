<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>View Listing</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head> 
<body class="container mt-5">
<div style="display: flex; gap:50px;">
<h1> <c:out value="${listing.address }"/> </h1>
<a href="/dashboard">Dashboard</a>
</div>


<p>Address: <c:out value="${listing.address }"> </c:out></p>
<p>Listing Date: <fmt:formatDate type = "date" value = "${listing.createdAt }" /></p>
<p>Price: $<c:out value="${String.format('%.2f',listing.price)}"> </c:out></p>

<c:if test="${listing.user.id == userId }">
	<a href="/listing/${listing.id }/edit" class="btn btn-info">edit</a>
	<form action="/delete/${listing.id }" method="post">
		<input type="hidden" name="_method" value="delete" />
		<input type="submit" value="Delete" class="btn btn-danger"/>
	</form>
</c:if>


</body>
</html>