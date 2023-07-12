<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Numbeans" %>
<%
Numbeans nb =(Numbeans)session.getAttribute("nb");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
入力された文字列
<%=nb.getOrg() %>
<br>
要素数
<%=nb.getSize() %>
<br>
最大値
<%=nb.getMax() %>
<br>
最小値
<%=nb.getMin() %>
<br>
合計
<%=nb.getSum() %>
<br>
<a href="form.jsp">戻る</a>
</p>
</body>
</html>