<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5 text-center">
	<h1 class ="text-center">Home Page</h1>
	<a href="/product/new">New Product</a> |
	<a href="/category/new">New Category</a>
	
	<div class="d-flex justify-content-around">
	
		<div class="card">
		<h3>Products</h3>
		<c:forEach var="eachProduct" items="${allProducts }">
		<p> <a href="/view/${eachProduct.id }/product"><c:out value="${eachProduct.productName }"/></a> </p>	
		</c:forEach>
		
		</div>
		
		<div class="card">
		<h3>Categories</h3>
		<c:forEach var="eachCategory" items="${allCategories }">
		<p> <a href="/view/${eachCategory.id }/category"><c:out value="${eachCategory.categoryName }"/></a> </p>
		</c:forEach>
		</div>
	
	
	
	
	
	</div>
	
	

</body>
</html>