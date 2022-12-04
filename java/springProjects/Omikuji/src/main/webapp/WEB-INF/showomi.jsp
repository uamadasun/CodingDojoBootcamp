<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Omikuji</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<div class="card" style="width: 18rem;">
  <div class="card-body text-dark bg-info">
    <h5 class="card-title">Here's your Omikuji!</h5>
    <p class="card-text">In ${number } years, you will live in ${city } with ${person }
as your roommate, ${hobby } for a living. The next time
you see a ${thing }, you will have good luck. Also, ${message }</p>
    
  </div>
</div>
<a href="/omikuji" class="card-link">Go back</a>


</body>
</html>