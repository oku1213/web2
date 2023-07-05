<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)session.getAttribute("name");
Integer age = (Integer)session.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションスコープ</title>
</head>
<body>
<p>名前:<%=name %>,年齢:<%=age %></p>

</body>
</html>