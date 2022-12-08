<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit My Expense</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head> 
<body class="container mt-5">
	<h3>Edit an expense:</h3>
	<a href="/expenses">Go back</a>
	<form:form action="/new/${expense.id }" method="put" modelAttribute="expense" class="form-group">
		<p> <form:errors path="expenseName" class="text-danger"/> </p>
		<p> <form:errors path="vendorName" class="text-danger"/> </p>
		<p> <form:errors path="amount" class="text-danger"/> </p>
		<p> <form:errors path="description" class="text-danger"/> </p>
		
		
		<p>
		<form:label path="expenseName"> Expense Name: </form:label>
		<form:input path="expenseName" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="vendorName"> Vendor: </form:label>
		<form:input path="vendorName" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="amount"> Amount: </form:label>
		<form:input type="number" step=".01" min="0" path="amount" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="description"> Description: </form:label>
		<form:input path="description" class ="form=control"/>
		</p>
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>


</body>
</html>