<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5 text-center">
<h1 class="text-center"> <c:out value="${product.productName }"/> </h1>
<a href="/">Home</a>
<h3>Categories</h3>
<c:forEach var="eachCategory" items="${product.categories }">
<p><c:out value="${eachCategory.categoryName }"/></p>
</c:forEach>

<h3>Add Category:</h3>

<form action="/join/${product.id }/product" method="post">
<select name="category">
<c:forEach var="oneCategory" items="${categories }">
				<option value="${oneCategory.id }">
					<c:out value="${oneCategory.categoryName }"/>
				<option>
			</c:forEach>
</select>
<input type="submit" value="Submit" class="btn btn-info"/>

</form>

<%-- <form:form action="/join/${product.id }/product" method="put" modelAttribute="categoryToAdd" class="form-group">
		<p> <form:errors path="categoryName" class="text-danger"/> </p>
		
		<form:select path="categoryName">
			<c:forEach var="oneCategory" items="${categories }">
				<form:option value="${oneCategory.id }">
					<c:out value="${oneCategory.categoryName }"/>
				</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Submit" class="btn btn-info"/>
		
		
</form:form>  --%>



</body>
</html>