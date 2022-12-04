<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current visit count</title>
</head>
<body>
<h4>You have visited ${countToShow} times.</h4>
<a href="/">Test Another visit?</a>
<p><a href="/reset"> Reset count?</a></p>


</body>
</html>