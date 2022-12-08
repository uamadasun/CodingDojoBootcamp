<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head> 
<body class="container mt-5">
<h1><c:out value="${dojo.dojoName }"/>'s Ninjas</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="eachNinja" items="${allNinjas }">
	<tr>
	<td><c:out value="${eachNinja.firstName }"/></td>
	<td><c:out value="${eachNinja.lastName }"/></td>
	<td><c:out value="${eachNinja.age }"/></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<a href="/dojos" class="btn btn-info">Back to dashboard</a>


</body>
</html>