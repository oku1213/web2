<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="model.*"%>
<%
Human h = (Human)request.getAttribute("human");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>名前:<%=h.getName() %>年齢:<%= h.getAge() %></p>

</body>
</html>