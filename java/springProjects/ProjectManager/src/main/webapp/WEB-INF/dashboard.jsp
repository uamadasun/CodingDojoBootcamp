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
<body>
<h1>Dashboard</h1>
<a href="/logout"> Log Out </a>  |
<a href="/new/project"> + New Project </a>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
	
		<c:forEach var="eachProject" items="${allProjects }">
			<tr>
				<td> <a href="/view/${eachProject.id }"><c:out value="${eachProject.title }"/></a> </td>
				<td><c:out value="${eachProject.teamLead.firstName }"/></td>
				<td><c:out value="${eachProject.dueDate}"/></td>
				<td><a href="/join/team/${eachProject.id }">Join Team</a></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>


</body>
</html>