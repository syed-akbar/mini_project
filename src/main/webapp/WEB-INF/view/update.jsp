<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updatePage</title>
</head>
<body>



<form action="update" method="post">
Name<input type="text" name="name" value="<%=request.getAttribute("name")%>">
Email<input type="text" name="email" value="<%=request.getAttribute("email")%>">

<input type="submit" value="Update">
</form>



</body>
</html>