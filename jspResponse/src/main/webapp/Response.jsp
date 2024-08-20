<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   String cid = request.getParameter("cid");
   String name = request.getParameter("name");

   out.println("<h1>Customer ID: " + cid + "</h1>");
   out.println("<h1>Customer Name: " + name + "</h1>");
   %>
</body>
</html>