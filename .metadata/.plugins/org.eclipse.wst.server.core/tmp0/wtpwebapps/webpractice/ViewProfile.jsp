<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
 String fName = (String)request.getAttribute("name");
 UserBean ub = (UserBean)application.getAttribute("ubean");
 out.println("Page belongs to : "+fName+"<br>");
 out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+
            ub.getAdd()+"&nbsp&nbsp"+
         ub.getPhNO()+
         "<a href='edit'>Edit</a><br>");
 %>
</body>
</html>