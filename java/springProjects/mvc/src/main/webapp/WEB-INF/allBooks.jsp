<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class ="container mt-5">
<table class="table table-hover">
	<thead>
	<tr>
		<th> ID </th>
		<th> Title </th>
		<th> Language </th>
		<th> #Pages </th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="eachBook" items="${allBooks }">
		<tr>
			<td><c:out value ="${eachBook.id }"/></td>
			<td><a href="/books/${eachBook.id }"><c:out value ="${eachBook.title }"/></a></td>
			<td><c:out value ="${eachBook.language }"/></td>
			<td><c:out value ="${eachBook.numberOfPages }"/></td>
		</tr>
		
		</c:forEach>
	
	</tbody>

	

</table>

</body>
</html>