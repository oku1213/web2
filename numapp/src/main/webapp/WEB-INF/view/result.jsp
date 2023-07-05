<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Num" %>
<%
Num num =(Num)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数字をカンマ区切りで入力</title>
</head>
<body>
<h1>入力された文字列を入力</h1>
<%= num.getOrg() %>
<p>要素数:<%=num.getSize() %></p>
<p>最大値:<%=num.getMax() %></p>
<p>最小値:<%=num.getMin() %></p>
<p>合計:<%=num.getSum() %></p>
<a href ="/numapp/NumMain">戻る</a>
</body>
</html>