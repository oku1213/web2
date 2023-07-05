<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User registerUser = (User)session.getAttribute("registerUser");
String id = registerUser == null ? "":registerUser.getId();
String pass = registerUser == null ? "":registerUser.getPass();
String name = registerUser == null ? "":registerUser.getName();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action ="RegisterUser" method ="post">
ログインID:<input type ="text" name="id" value = "<%=id %>"><br>
パスワード:<input type ="password" name ="pass" value ="<%=pass %>"><br>
名前:<input type ="text" name ="name" value ="<%=name %>"><br>
<input type ="submit" value ="確認">
</form>

</body>
</html>