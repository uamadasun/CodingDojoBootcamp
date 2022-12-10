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


<body class="container mt-5">
<h1><c:out value="${book.title }"/></h1>
	<c:if test="${book.creator.id == userId }">
		<h4>You read "<c:out value="${book.title }"/>" by <c:out value="${book.author }" /></h4>
		<p>Here are your thoughts:</p>
		<div class="card"><c:out value="${book.thoughts }"/></div>
		<a href="/books/${book.id }/edit" class="btn btn-primary">Edit</a>
		<form action="/delete/${book.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input type="submit" value="Delete" class="btn btn-danger"/>
		</form>
	</c:if>
	
	<c:if test="${book.creator.id != userId }">
	<h4><c:out value="${book.creator.userName }"/> read "<c:out value="${book.title }"/>" by <c:out value="${book.author }" /></h4>
	<p>Here are <c:out value="${book.creator.userName }"/>'s thoughts:</p>
	<div class="card"><c:out value="${book.thoughts }"/></div>
	</c:if>
	<a href="/home">back to the shelves</a>


</body>
</html>