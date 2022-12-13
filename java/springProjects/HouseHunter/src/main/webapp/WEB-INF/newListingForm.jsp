<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Listing</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class = "container">

<h3>New Listing</h3>
	<a href="/dashboard">Dashboard</a>
	<form:form action="/listing/new" method="POST" modelAttribute="newListing" class="form-group">
		<p> <form:errors path="address" class="text-danger"/> </p>
		<p> <form:errors path="price" class="text-danger"/> </p>
		
		
		<p>
		<form:label path="address"> Address: </form:label>
		<form:input path="address" class ="form-control"/>
		</p>
		
		<p>
		<form:label path="price"> Price: </form:label>
		<form:input type="number" step=".01" placeholder="$0.00" path="price" class ="form=control"/>
		</p>
		
		<form:hidden path="user" value="${userId}"/>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>

</body>
</html>