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
<h1>Hello, <c:out value="${user.userName }"/>!</h1>
<a href="/logout"> Log Out </a>

 <table class="table table-hover">
 <thead>
 <th>Baby Names</th>
 <th></th>
 <th></th>
 <th></th>
 <th>Votes</th>
 </thead>
	<tbody>
	
		<c:forEach var="eachBabyName" items="${allBabyNames }">
			<tr>
				
				<c:if test="${eachBabyName.users.contains(user)}">
				<td> <p>You like this name</p></td> 
				<td><a href="/view/${eachBabyName.id }"><c:out value="${eachBabyName.babyName}"/></a></td>
				<td><c:out value="${eachBabyName.gender}"/></td>
				<td>Origin:<c:out value="${eachBabyName.origin}"/></td>
				<td><c:out value="${eachBabyName.users.size()}"/></td>
				</c:if>
				
				<c:if test="${!eachBabyName.users.contains(user)}">
				<td> <form action="/upvote/${eachBabyName.id }" method="post">
				<input type="submit" value="upvote!"/>
				</form></td> 
				<td><a href="/view/${eachBabyName.id }"><c:out value="${eachBabyName.babyName}"/></a></td>
				<td><c:out value="${eachBabyName.gender}"/></td>
				<td>Origin:<c:out value="${eachBabyName.origin}"/></td>
				<td><c:out value="${eachBabyName.users.size()}"/></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/names/new" class="btn btn-success">new name</a>


</body>
</html>




