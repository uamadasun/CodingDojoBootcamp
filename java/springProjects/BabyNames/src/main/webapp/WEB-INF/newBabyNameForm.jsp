<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Baby Names</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class = "container">

	<h3>Add a Name!</h3>
	<a href="/dashboard">Back</a>
	<form:form action="/names/new" method="post" modelAttribute="newBabyName" class="form-group">
		<p> <form:errors path="babyName" class="text-danger"/> </p>
		<p> <form:errors path="gender" class="text-danger"/> </p>
		<p> <form:errors path="origin" class="text-danger"/> </p>
		<p> <form:errors path="meaning" class="text-danger"/> </p>
		
		
		<p>
		<form:label path="babyName"> Title: </form:label>
		<form:input path="babyName" class ="form-control"/>
		</p>
		
		
		<form:label path="gender"> Gender: </form:label>
		<form:select path="gender">
		<option value="neutral">Neutral</option>
		<option value="male">Male</option>
		<option value="female">Female</option>
		</form:select>
		
		<p>
		<form:label path="origin"> Origin: </form:label>
		<form:input path="origin" class ="form-control"/>
		</p>
		
		<form:hidden path="user" value="${userId}"/>
		
		<p>
		<form:label path="meaning"> Meaning: </form:label>
		<form:input path="meaning" class ="form-control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>

</body>
</html>