<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String fName=(String)request.getAttribute("name");
UserBean ub = (UserBean)application.getAttribute("ubean");
out.println("Page belongs to : "+fName+"<br>");
%>
<form action="update" method="post">
    Address:<input type="text" name="add"  value=<%=ub.getAdd()%> ><br>
    phNo: <input type="text" name="phno" value=<%=ub.getPhNO() %>> <br>
    <input type="submit" value="UpdateProfile">
</form>

</body>
</html>