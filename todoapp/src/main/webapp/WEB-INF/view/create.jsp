<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*,java.util.*" %>
<%
List<Todo> list=(List<Todo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>todolist</title>
</head>
<body>
<a href="/todoapp/Create">新規</a>
<%if(list != null && list.size() > 0){ %>
<table border="1">
<%for(Todo t:list){ %>
<tr>
<td><%=t.getId() %></td>
<td><%=t.getTitle() %></td>
<td>
<% for(int i = 0; i < t.getDegree();i++){%>
★
<%} %>
</td>
<td><a href="/todoapp/Update?id=<%=t.getId()%>">更新</a>
<a href="/todoapp/Delete?id=<%=t.getId()%>" onclick="return confirm('id=<%=t.getId()%>を削除してよろしいですか？');">削除</a></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>