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

<p>Project: <c:out value="${project.title }"/></p>
<p>Project: <c:out value="${project.description }"/></p>

<p>Project: <c:out value="${project.dueDate }"/></p>
<a href="/tasks/${project.id }">See tasks!</a>
<a href="/delete/project/${project.id }"></a>


</body>
</html>