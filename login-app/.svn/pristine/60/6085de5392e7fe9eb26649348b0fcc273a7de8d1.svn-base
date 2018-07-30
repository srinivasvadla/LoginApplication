<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
<title>Signup</title>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">



<style >
table {
    border-collapse: collapse;
}

table, td{
    border: 1px solid black;
}
</style>
</head>
<body style="background-image: url('images/bg-01.jpg');">

<form action="registerUser">

<h2 align="center"><caption>Please Register Here</caption></h2>
<table align="center" >

<tr>
 <th>User Name  :</th><th> <input type="text" name="email"></th>
 </tr>
 <tr>
 <th>Password   :</th><th> <input type="password" name="pwd"></th>
 </tr>
 <tr>
 <th colspan="2" align="center"><input type="submit" value="Register"></th>
 </tr>
 

</table>



</form>


<h1 align="center">
<c:if test="${not empty regResponse}">
 <c:out value="${regResponse}"/>
</c:if>
</h1>
</body>
</html>