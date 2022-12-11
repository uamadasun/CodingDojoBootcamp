<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>


<body class="container">

<div class="d-flex align-items-center">
<h1 class="mr-auto p-2">Welcome, <c:out value="${user.userName }"/>!</h1>
<a href="/logout" class="p-2">Logout</a>
</div>

<div class="d-flex">
<p class="p-2">Books from everyone's shelves:</p>
<a href="/books/new" class="ml-auto p-2">+ Add a Book to my Shelf</a>
<a href="/bookmarket">Go to Book Market</a>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="eachBook" items="${allBooks }">
			<tr>
				<td> <c:out value="${eachBook.id }"/> </td>
				<td><a href="/books/${eachBook.id }"><c:out value="${eachBook.title }"/></a></td>
				<td><c:out value="${eachBook.author }"/></td>
				<td><c:out value="${eachBook.creator.userName}"/></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
</body>
</html>