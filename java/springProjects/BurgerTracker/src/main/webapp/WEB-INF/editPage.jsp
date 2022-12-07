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
	<title>Edit a Burger</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container mt-5">

<h3>Edit Burger:</h3>
<form:form action="/new/${burger.id }" method="PUT" modelAttribute="burger" class="form-group">
	<p><form:errors path="burgerName" class="text-danger"/></p>
	<p><form:errors path="restaurantName" class="text-danger"/></p>
	<p><form:errors path="rating" class="text-danger"/></p>
	<p><form:errors path="notes" class="text-danger"/></p>

	<p>
	<form:label path="burgerName">Burger Name</form:label>
	<form:input path="burgerName" class="form-control" value="${burger.burgerName }"/>
	</p>
	
	<p>
	<form:label path="restaurantName">Restaurant Name</form:label>
	<form:input path="restaurantName"  class="form-control" value="${burger.restaurantName }"/>
	</p>
	
	<p>
	<form:label path="rating">Rating (out of 5)</form:label>
	<form:input type="number" path="rating" class="form-control" value="${burger.rating }"/>
	</p>
	
	<p>
	<form:label path="notes">Notes</form:label>
	<form:textarea path="notes" class="form-control" value="${burger.notes }"/>
	</p>
	
	<input type="submit" value="Submit" class="btn btn-success"/>

</form:form>

</body>
</html>