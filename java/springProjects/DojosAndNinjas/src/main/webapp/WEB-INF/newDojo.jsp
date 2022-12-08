<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container mt-5">


<h3>New Dojo:</h3>
	<form:form action="/dojos/new" method="post" modelAttribute="newDojo" class="form-group">
		<p> <form:errors path="dojoName" class="text-danger"/> </p>
		
		<p>
		<form:label path="dojoName"> Name: </form:label>
		<form:input path="dojoName" class ="form=control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>
	
	<a href="/dojos"> Go back </a>

</body>
</html>