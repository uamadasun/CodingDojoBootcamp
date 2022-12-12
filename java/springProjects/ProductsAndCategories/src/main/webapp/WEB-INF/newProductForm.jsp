<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5 text-center">

<h3>New Product</h3>
	<a href="/">Home</a>
	<form:form action="/product/new" method="POST" modelAttribute="newProduct" class="form-group">
	<p> <form:errors path="productName" class="text-danger"/> </p>
	<p> <form:errors path="description" class="text-danger"/> </p>
	<p> <form:errors path="price" class="text-danger"/> </p>

		<p>
		<form:label path="productName"> Product Name: </form:label>
		<form:input path="productName" class ="form-control"/>
		</p>
		
		<p>
		<form:label path="description"> Description: </form:label>
		<form:input path="description" class ="form-control"/>
		</p>
		
		<p>
		<form:label path="price"> Price: </form:label>
		<form:input type="number" path="price" class ="form-control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>


</body>
</html>