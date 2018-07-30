<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page import="java.util.*"%>
<%--  <%@ page import="//src.w3s.servlet.login.Mail"%>  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>


<P>In Deleted mails  ${deletedmailsCount}</P>
<c:choose>
		<c:when test="${!empty deletedmails}">
			<h1 align="center" style="color: blue">Deleted mails</h1>		

			<table border="1" width="100%" height="100%">
				<tr>
					<th>FromMail</th>
					<th>Content</th>
					<th>To Mail</th>
					
				</tr>d
				<c:forEach var="dto" items="${deletedmails}">
					<tr>
						<td>${dto.mailFrom}</td>
						<td>${dto.mailedDateTime}</td>
						<td>${dto.mailContent}</td>
						
						
						<!-- 
						Mail mail = new Mail(String.valueOf(res.getInt("mail_uniq_id")),
					res.getString("from_mail_id"), res.getString("to_mail"),
					 res.getString("message"),res.getString("subject"),res.getString("file_name"));
						ssriniv
 -->
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red">
				<b> No Deleted Mails found</b>
			</h1>
		</c:otherwise>
	</c:choose>



</body>
</html>