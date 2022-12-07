<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BURGER TRACKER</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class= "container mt-5">
<h1>Burger Tracker</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Burger Name</th>
			<th>Restaurant Name</th>
			<th>Rating (out of 5)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="eachBurger" items="${allBurgers}">
		<tr>
			<td><c:out value="${eachBurger.burgerName }"/></td>
			<td><c:out value="${eachBurger.restaurantName }"/></td>
			<td><c:out value="${eachBurger.rating}"/> </td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<h3>Add a Burger:</h3>
<form:form action="/" method="POST" modelAttribute="burger" class="form-group">
	<p>
	<form:label path="burgerName">Burger Name</form:label>
	<form:errors path="burgerName" class="text-danger"/>
	<form:input path="burgerName" class="form-control"/>
	</p>
	
	<p>
	<form:label path="restaurantName">Restaurant Name</form:label>
	<form:errors path="restaurantName" class="text-danger"/>
	<form:input path="restaurantName"  class="form-control"/>
	</p>
	
	<p>
	<form:label path="rating">Rating (out of 5)</form:label>
	<form:errors path="rating" class="text-danger"/>
	<form:input type="number" path="rating" class="form-control"/>
	</p>
	
	<p>
	<form:label path="notes">Notes</form:label>
	<form:errors path="notes" class="text-danger"/>
	<form:textarea path="notes" class="form-control"/>
	</p>
	
	<input type="submit" value="Submit" class="btn btn-success"/>

</form:form>

</body>
</html>