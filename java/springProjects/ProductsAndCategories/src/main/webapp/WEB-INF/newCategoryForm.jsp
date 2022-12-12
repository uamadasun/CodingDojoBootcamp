<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5 text-center">

<h3>New Category</h3>
	<a href="/">Home</a>
<form:form action="/category/new" method="post" modelAttribute="newCategory" class="form-group">
		<p> <form:errors path="categoryName" class="text-danger"/> </p>
		
		<p>
		<form:label path="categoryName"> Name: </form:label>
		<form:input path="categoryName" class ="form=control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>

</body>
</html>