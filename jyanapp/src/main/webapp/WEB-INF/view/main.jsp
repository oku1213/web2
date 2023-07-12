<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Jyan" %>
<%
Jyan jyan = (Jyan)session.getAttribute("jyan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんアプリ</title>
</head>
<body>
<form action ="Main" method ="post">
<input type ="radio" name ="hand" value ="グー">グー
<input type="radio" name="hand" value="チョキ">チョキ
<input type="radio" name="hand" value="パー">パー
<input type="submit" value="送信">
</form>

<%if(jyan != null){ %>
<p>あなたは<%=jyan.getUserHand() %>
<p>PCは<%=jyan.getPcHand() %></p>
<p><%=jyan.getResult() %></p>
<p><%=jyan.getWin() %>勝ち-<%=jyan.getLose() %>負け</p>
<a href ="Main">retry!</a>
<%} %>
</body>
</html>