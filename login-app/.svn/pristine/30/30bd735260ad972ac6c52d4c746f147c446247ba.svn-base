<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<style>
button {
    background-color: #daa520;
    border: none;
    color: white;
  padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
}
button {
border-radius: 10px;
}
</style>

</head>
<body>

<form action="authenticate">


<table align="center" border="1" >
<tr>
 <th>User Name  :</th><th> <input type="text" name="email"></th>
 </tr>
 <tr>
 <th>Password   :</th><th> <input type="password" name="pwd"></th>
 </tr>
<tr><th><button class="glyphicon glyphicon-envelope"  type="submit" value="Login">Login</button></th><th><button><a href="Signup.jsp">Signup</button></a></th></tr>

</table>

</form>
<h1 align="center">
<c:if test="${not empty loginResponse}">
 <c:out value="${loginResponse}"/>
</c:if>
</h1>

</body>
</html>