<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Left Frame</title>
<style>
button {
    background-color: #daa520;
    border: none;
    color: white;
    width: 100%;
   max-width: 250px;
   box-sizing: border-box;
    padding: 5px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 13px;
    margin: 2px 2px;
}
button {
border-radius: 15px;
}

</style>

<!-- style="background-color:LemonChiffon;background-image: url('images/pic.gif');"
 -->
</head>
<body bgcolor="7B68EE" >

<a href="createMail.jsp" target="body"><button>CREATE MAIL</button></a>
<a href="AllIncomingMails" target="body"><button>INBOX</button></a>
<a href="AllOutboxMails" target="body"><button>OUTBOX</button></a>

<a href="AllMails" target="body"><button>SEE MAIL</button></a>
<a href="GetDeletedMail" target="body"><button>TRASH</button></a>


</body>
</html>