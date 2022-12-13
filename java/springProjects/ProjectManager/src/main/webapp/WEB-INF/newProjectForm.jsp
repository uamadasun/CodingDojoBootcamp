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


	<h3>Create a Project</h3>
	<a href="/dashboard">Back</a>
	<form:form action="/new/project" method="post" modelAttribute="newProject" class="form-group">
		<p> <form:errors path="title" class="text-danger"/> </p>
		<p> <form:errors path="description" class="text-danger"/> </p>
		<p> <form:errors path="dueDate" class="text-danger"/> </p>
		
		
		<p>
		<form:label path="title"> Title: </form:label>
		<form:input path="title" class ="form-control"/>
		</p>
		
		<p>
		<form:label path="description"> Description: </form:label>
		<form:input path="description" class ="form-control"/>
		</p>
		
		<form:hidden path="teamLead" value="${userId}"/>
		
		<p>
		<form:label path="dueDate"> Due Date: </form:label>
		<form:input type="date" path="dueDate" class ="form-control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>

</body>
</html>