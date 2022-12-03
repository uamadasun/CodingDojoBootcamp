<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Fruit Store</title>
	<link rel="stylesheet" href="/css/style.css"/>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	
</head>

<body>


<div class="card border border-5" style="width: 18rem;">
  <div class="card-body">
  <h1 class="card-title">Fruit Store</h1>
  <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="eachFruit" items="${fruitList}">
    <tr>
      <td><c:out value="${eachFruit.name}"></c:out></td>
      <td><c:out value="${eachFruit.price}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
  </div>
</div>

</body>
</html>