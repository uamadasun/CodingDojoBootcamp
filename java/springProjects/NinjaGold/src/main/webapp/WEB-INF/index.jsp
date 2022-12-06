<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container mt-5">
<h3>Your Gold: <c:out value="${count}"/> </h3>

<div style = "display: flex; gap:50px;">



<div>
<form action="/gold" method="post">
	<h4>Farm</h4>
	<p>(earns 5 gold)</p>
	<div>
	<input type="hidden" name="location" value="farm"/>
	<input type="submit" class="btn btn-info" value="Find Gold!"/>
	</div>
</form>
</div>

<div>
<form action="/gold" method="post">
	<h4>Cave</h4>
	<p>(earns 10 gold)</p>
	<div>
	<input type="hidden" name="location" value="cave"/>
	<input type="submit" class="btn btn-secondary" value="Find Gold!"/>
	</div>
</form>
</div>


<div>
<form action="/gold" method="post">
	<h4>House</h4>
	<p>(earns 20 gold)</p>
	<div>
	<input type="hidden" name="location" value="house"/>
	<input type="submit" class="btn btn-warning" value="Find Gold!"/>
	</div>
</form>
</div>

<div>
<form action="/gold" method="post">
	<h4>Quest</h4>
	<p>(earns 30 gold)</p>
	<div>
	<input type="hidden" name="location" value="quest"/>
	<input type="submit" class="btn btn-success" value="Find Gold!"/>
	</div>
</form>
</div>





</div>





</body>
</html>