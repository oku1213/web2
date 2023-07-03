<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String date = request.getParameter("date");
String color = request.getParameter("color");
String size = request.getParameter("size");
int dogAge = Integer.parseInt(request.getParameter("age"));
int humanAge = dogAge * 7;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>犬年齢計算機</title>
</head>
<body>
<p>結果</p>
<p><%=name %>(<%=dogAge %>歳)ちゃんの年齢を人間に換算すると<%=humanAge %>歳です</p>
<p><%=color %>:<%=size %></p>
</body>
</html>