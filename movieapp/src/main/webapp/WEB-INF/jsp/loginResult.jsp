<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>映画</title>
</head>
<body>
<h1>ログイン結果画面</h1>
<% if(loginUser != null){ %>
<p>ログインに成功しました<br>
ようこそ<%=loginUser.getName() %>さん<br>
<a href = "Main">つぶやきの投稿・閲覧へ</a>
<%}else { %>
ログインに失敗しました
<a href ="index.jsp">トップへ</a>
<%} %>
</p>
</body>
</html>