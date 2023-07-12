<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg =(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン</title>
</head>
<body>
<h1>メイン画面</h1>
<p>
<%=loginUser.getName() %>さん、ログイン中<br>
<a href ="Logout">ログアウト</a><br>
<a href ="Main">更新</a>
<form action="" method="post">
映画タイトル：<input type="text" name="title"><br>
コメント：<textarea name="text"></textarea>
<input type="submit" value="コメントする">
</form>
<% if(errorMsg != null){ %>
<%=errorMsg %>
<%} %>
<table border="1">
<tr>
<th>投稿者</th>
<th>映画タイトル</th>
<th>コメント</th>
</tr>
<% for (Mutter mutter:mutterList) {%>
<tr>
<td><%=mutter.getUserName() %></td>
<td><%=mutter.getTitle() %></td>
<td><%=mutter.getText() %></td>
</tr>
<%} %>
</table>
</body>
</html>