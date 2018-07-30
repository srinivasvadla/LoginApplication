<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="sendMail" method="POST" enctype="multipart/form-data">
<pre>
To                : <input type="text" name="tomail">

subject           : <input type="text" name="subject"  length="20%" >



Post your Message : <textarea rows="5" cols="100" name="mailContent"></textarea>
File Upload 	  : <input type="file" name="file" value="browse" id="file" multiple/> 


<input type="submit" value="Send Mail">

</pre>



</form>


<a href="logout.jsp">Logout</a>

<c:if test="${not empty mailStatusMsg}">
 <c:out value="${mailStatusMsg}"/>
</c:if>

</body>
</html>