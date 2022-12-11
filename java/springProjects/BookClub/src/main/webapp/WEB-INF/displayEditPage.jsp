<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>


<body class="container">


	<h3>Change your Entry</h3>
	<form:form action="/books/${book.id}/edit" method="put" modelAttribute="book" class="form-group">
		<p> <form:errors path="title" class="text-danger"/> </p>
		<p> <form:errors path="author" class="text-danger"/> </p>
		<p> <form:errors path="thoughts" class="text-danger"/> </p>
		
		
		<p>
		<form:label path="title"> Title: </form:label>
		<form:input path="title" class ="form-control"/>
		</p>
		
		<p>
		<form:label path="author"> Author: </form:label>
		<form:input path="author" class ="form-control"/>
		</p>
		
		<form:hidden path="creator"/>
		
		<p>
		<form:label path="thoughts"> My Thoughts: </form:label>
		<form:textarea path="thoughts" class ="form-control"/>
		</p>
		<form:hidden path="borrowingUsers"/>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
		
	
	</form:form>
	
	<form action="/delete/${book.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" class="btn btn-danger"/>
				</form>

</body>
</html>