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
<h1><c:out value="${babyName.babyName }"/></h1>

<p>(Added by <c:out value="${babyName.user.userName }"/>)</p>
<p>Gender: <c:out value="${babyName.gender }"></c:out></p>
<p>Origin: <c:out value="${babyName.origin }"></c:out></p>

<c:if test="${babyName.users.contains(user)}">
<h4>You voted for this name.</h4>
</c:if>

<c:if test="${!babyName.users.contains(user)}">
	<form action="/upvote/${babyName.id }" method="post">
		<input type="submit" value="upvote!"/>
	</form>
</c:if>

<p>Meaning: <c:out value="${babyName.meaning }"></c:out></p>

<c:if test="${babyName.user.id == userId }">
<a href="/babyname/${babyName.id }/edit" class="btn btn-info">edit</a>
</c:if>






</body>
</html>