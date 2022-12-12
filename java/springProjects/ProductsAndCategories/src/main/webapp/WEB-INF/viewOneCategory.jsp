<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5 text-center">

<h1 class="text-center"> <c:out value="${category.categoryName }"/> </h1>
<a href="/">Home</a>
<h3>Products</h3>
<c:forEach var="eachProduct" items="${category.products }">
<p> <c:out value="${eachProduct.productName }"/> </p>

</c:forEach>

<h3>Add Product:</h3>
<form action="/join/${category.id }/category" method="post">
	<select name="product">
		<c:forEach var="oneProduct" items="${productsNotInCategory }">
			<option value="${oneProduct.id }"> 
				<c:out value="${oneProduct.productName }"/> 
			<option>
		</c:forEach>
	</select>
	<input type="submit" value="Submit" class="btn btn-info"/>

</form>


</body>
</html>