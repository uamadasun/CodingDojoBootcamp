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
<div style="display: flex; gap:50px;">
<h1>Expense Details</h1>
<a href="/expenses">Go back</a>
</div>


<p>Expense Name: <c:out value="${expense.expenseName }"> </c:out></p>
<p>Expense Description: <c:out value="${expense.description }"> </c:out></p>
<p>Vendor: <c:out value="${expense.vendorName }"> </c:out></p>
<p>Amount Spent: $<c:out value="${String.format('%.2f',expense.amount)}"> </c:out></p>


</body>
</html>