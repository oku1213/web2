<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*" %>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
//アプリケーションスコープに保存されたユーザー情報を取得
List<Mutter> mutterList = (List<Mutter>)request.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得	
String errorMsg = (String)request.getAttribute("errorMsg");
Mutter m = (Mutter) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ３</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Update">更新</a></p>
<form action="Main" method="post">
<input type="text" name="userName" value="<%=m.getUserName() %>">
<input type="text" name="userText" value="<%=m.getUserText() %>">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter:mutterList){ %>
<p><%= mutter.getUserName() %>:<%= mutter.getUserText() %></p>
<%} %>
</body>
</html>