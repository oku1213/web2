<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="model.*" %>    
<%
List<Fruits> list = new ArrayList<>();
list.add(new Fruits("いちご","栃木",600));
list.add(new Fruits("みかん","愛媛",500));
list.add(new Fruits("りんご","青森",120));
list.add(new Fruits("ぶどう","山梨",700));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fruits/css/main.css">
</head>
<body>
<div id="container">
<h1>果物価格表</h1>
<table border="1">
<tr><th>名前</th><th>産地</th><th>価格</th></tr>
<% for(Fruits f:list){ %>
<tr>
<td><%=f.getName() %></td>
<td><%=f.getArea() %></td>
<td><%=f.getPrice() %></td>
</tr>
<%} %>
</table><!-- container -->
</div>

</body>
</html>