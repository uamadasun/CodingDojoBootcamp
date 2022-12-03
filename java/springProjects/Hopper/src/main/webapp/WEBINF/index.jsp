<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Simple Receipt</title>
</head>
<body>
	<h1>Customer Name: ${name}</h1>
	<h2>Item name: ${itemName }</h2>
	<h2>Price: $${price }</h2>
	<h2>Description: ${description }</h2>
	<h2>Vendor: ${vendor}</h2>

</body>
</html>