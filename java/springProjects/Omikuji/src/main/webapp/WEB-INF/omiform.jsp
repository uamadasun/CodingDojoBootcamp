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
<h1 class="center ">Send an Omikuji!</h1>


<div class="card" style="width: 18rem;">
  <div class="card-body">
  <form action="/omikuji/new" method="post">

<label>Pick any number from 5 to 25</label>
<input type="number" name="number"/>

<label for="city">Enter the name of any city.</label>
<input type="text" name="city" />

<label for="person">Enter the name of any real person.</label>
<input type="text" name="person" />

<label for="hobby">Enter professional endeavor or hobby:</label>
<input type="text" name="hobby" />

<label for="thing">Enter any type of living thing.</label>
<input type="text" name="thing"/>

<label for="message">Say something nice to someone:</label>
<textarea name="message" id="message" cols="30" rows="5"></textarea>

<label >Send and show a friend</label>
<input type="submit" value="Send" />
</form>
    
    
  </div>
</div>










</body>
</html>