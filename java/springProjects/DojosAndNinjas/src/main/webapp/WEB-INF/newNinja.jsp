<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container mt-5">
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="newNinja" class="form-group">
		<p> <form:errors path="firstName" class="text-danger"/> </p>
		<p> <form:errors path="lastName" class="text-danger"/> </p>
		<p> <form:errors path="age" class="text-danger"/> </p>
		<p> <form:errors path="dojo" class="text-danger"/> </p>
		
		<p>
		<form:label path="dojo"> Dojo: </form:label>
		<form:select path="dojo">
			<c:forEach var="eachDojo" items="${allDojos }">
				<form:option value="${eachDojo.id }" path="dojo">
					<c:out value="${eachDojo.dojoName }"/>
				</form:option>
			</c:forEach>
		</form:select>	
		
		<p>
		<form:label path="firstName"> First name: </form:label>
		<form:input path="firstName" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="lastName"> Last Name: </form:label>
		<form:input path="lastName" class ="form=control"/>
		</p>
		
		<p>
		<form:label path="age"> Age: </form:label>
		<form:input type="number" path="age" class ="form=control"/>
		</p>
		
		<input type="submit" value="Submit" class="btn btn-info"/>
	
	</form:form>



<a href="/dojos"> Go back</a>
</body>
</html>