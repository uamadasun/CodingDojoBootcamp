<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Lender Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>


<body class="container">
<a href="/home">back to the shelves</a>
<p>Hello <c:out value="${user.userName }"/>. Welcome to..</p>
<h1>The Book Broker</h1>
<h4>Available Books to Borrow</h4>
<table class="table table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="eachBook" items="${bookList }">
			<tr>
				<td> <c:out value="${eachBook.id }"/> </td>
				<td><a href="/books/${eachBook.id }"><c:out value="${eachBook.title }"/></a></td>
				<td><c:out value="${eachBook.author }"/></td>
				<td><c:out value="${eachBook.creator.userName}"/></td>
				<td>
				
				<c:if test="${eachBook.creator.id == user.id }">
				<a href="/books/${eachBook.id }/edit" class="btn btn-info">edit</a>
				<form action="/delete/${eachBook.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" class="btn btn-danger"/>
				</form>
				</c:if>
				
				<c:if test="${eachBook.creator.id != user.id }">
				
				
				<form action="/borrow/${eachBook.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Borrow" class="btn btn-warning"/>
				</form>
			
				</c:if>
				
				</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>








<!--  BORROWED BOOKS-->
<h4>Books I'm Borrowing..</h4>
<table class="table table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="eachBook" items="${user.getBorrowedBooks() }">
			<tr>
				<td> <c:out value="${eachBook.id }"/> </td>
				<td><a href="/books/${eachBook.id }"><c:out value="${eachBook.title }"/></a></td>
				<td><c:out value="${eachBook.author }"/></td>
				<td><c:out value="${eachBook.creator.userName}"/></td>
				<td>
				
				<form action="/return/${eachBook.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Return" class="btn btn-primary"/>
				</form>
				
					
				</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>


</body>
</html>