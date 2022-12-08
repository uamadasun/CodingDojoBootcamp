<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Read Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head> 

<body class="container mt-5">
<h1>Save Travels</h1>
		<table class="table table-hover">
			<thead>
				<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="eachExpense" items="${allExpenses }" > 
			<tr>
			
			
			<td> <a href="/expenses/viewOne/${eachExpense.id }"><c:out value="${eachExpense.expenseName }"/></a> </td>
			<td> <c:out value="${eachExpense.vendorName }"/> </td>
			<td> $<c:out value="${String.format('%.2f',eachExpense.amount) }"/> </td>
			
			<td> 
				<a href="/edit/${eachExpense.id }" class="btn btn-primary">Edit</a>
				<form action="/delete/${eachExpense.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" class="btn btn-danger"/>
				</form>
			</td>
			</tr>
			</c:forEach>
			</tbody>
	
		</table> 
		
	<h3>Add an expense:</h3>
	<form:form action="/expenses" method="POST" modelAttribute="newExpense" class="form-group">
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
		<form:input type="number" step=".01" placeholder="$0.00" path="amount" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="description"> Description: </form:label>
		<form:input path="description" class ="form=control"/>
		</p>
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>
</body>
</html>