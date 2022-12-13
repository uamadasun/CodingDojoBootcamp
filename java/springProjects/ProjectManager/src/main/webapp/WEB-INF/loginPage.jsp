<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Project Manager</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container mt-5">

<h1>Project Manager</h1>
<h4>A place for teams to manage projects.</h4>

<div class="container mt-5 d-flex justify-content-around">
	<div class="register">
		<h3>Registration</h3>
		<form:form action="/register" method="post" modelAttribute="newUser" class="form">
			<p> <form:errors path="firstName" class="text-danger"/> </p>
			<p> <form:errors path="lastName" class="text-danger"/> </p>
			<p> <form:errors path="email" class="text-danger"/> </p>
			<p> <form:errors path="password" class="text-danger"/> </p>
			<p> <form:errors path="confirm" class="text-danger"/> </p>
			
			
			<p>
			<form:label path="firstName"> First Name: </form:label>
			<form:input path="firstName" class ="form-control"/>
			</p>
			
			<p>
			<form:label path="lastName"> Last Name: </form:label>
			<form:input path="lastName" class ="form-control"/>
			</p>
			
			<p>
			<form:label path="email"> Email: </form:label>
			<form:input path="email" class ="form-control"/>
			
			<p>
			<form:label path="password"> Password: </form:label>
			<form:input type="password" path="password" class ="form-control"/>
			</p>
			
			<p>
			<form:label path="confirm"> Confirm Password: </form:label>
			<form:input type="password" path="confirm" class ="form-control"/>
			</p>
			<input type="submit" value="Submit" class="btn btn-info"/>
		</form:form>
	</div>

	<div class="login">
			<h3>Login</h3>
		<form:form action="/login" method="post" modelAttribute="newLogin" class="form-group">
			<p> <form:errors path="email" class="text-danger"/> </p>
			<p> <form:errors path="password" class="text-danger"/> </p>
			
			<p>
			<form:label path="email"> Email: </form:label>
			<form:input path="email" class ="form-control"/>
			
			<p>
			<form:label path="password"> Password: </form:label>
			<form:input type="password" path="password" class ="form-control"/>
			</p>

			<input type="submit" value="Submit" class="btn btn-info"/>
		</form:form>
	</div>

</div>


</body>
</html>