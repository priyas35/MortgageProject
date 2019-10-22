 <%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
<%
Random rand = new Random();
int n = rand.nextInt(90000) + 10000;

%>

   
        CIBIL SCORE<input type="text" name="order" value=<%=n%> />
   If Cibil Score Greater than 1000 means   <a href="/approove" > Click Here</a>
        
    
</body>
</html>