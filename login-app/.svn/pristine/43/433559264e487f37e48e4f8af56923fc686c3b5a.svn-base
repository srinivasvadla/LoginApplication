<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page import="java.util.*"%>
<%-- <%@ page import="//src.w3s.servlet.login.Mail"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mails</title>
</head>
<body>


   <!--To get the outbox  mails  -->

<c:choose>
  <c:when test="${!empty allInboxMails}">
     <h1 align="center" style="color:red">Inbox Mails </h1>
   <h2 style="color:red">Inbox(${allInboxMailsCount}) </h2>
     
     <table   border="1" width="100%" height="100%" >
       <tr><th>FromMail</th><th>Mail Date</th><th>Content</th></tr>
       <c:forEach var="dto" items="${allInboxMails}">
          <tr>
            <td >${dto.mailFrom}</td>
           
            <td>${dto.mailedDateTime}</td>
             <td>${dto.mailContent}</td>
           	<td><a href="deleteAMail?mail_uniq_id=${dto.mailUniqueId}"><button>Delete this mail</button></a></td>
          </tr>
       </c:forEach>
     </table>
  </c:when>
  <c:otherwise>
     <h1 style="color:red"><b> No Mails found</b></h1>
  </c:otherwise>
</c:choose>

   <!--To get the incoming mails mails  -->


   
   <!--To get the trash mails  -->

	<%-- <c:choose>
		<c:when test="${!empty deletedmails}">
			<h1 align="center" style="color: red">Deleted mails</h1>
			<h2 style="color: red">${deletedmails}</h2>

			<table border="1" width="100%" height="100%">
				<tr>
					<th>FromMail</th>
					<th>Mail Date</th>
					<th>Content</th>
				</tr>
				<c:forEach var="dto" items="${deletedmails}">
					<tr>
						<td>${dto.mailFrom}</td>
						<td>${dto.mailedDateTime}</td>
						<td>${dto.mailContent}</td>
						<td>${dto.mailUniqueId}</td>

					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red">
				<b> No Mails found</b>
			</h1>
		</c:otherwise>
	</c:choose>
 --%>

</body>
	</html>