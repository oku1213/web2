<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<Person> list=(List<Person>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Joytas9</title>
</head>
<body>
<a href="/joytas9/Create">新規登録</a>
<%if(list != null && list.size() > 0){ %>

<table border="1">
<%for(Person p:list){ %>

<tr>

<td><%=p.getId() %></td>


<td><%=p.getName() %></td>


<td><%=p.getAge() %></td>


<td><a href="/joytas9/Update?id=<%=p.getId()%>">更新</a>
<a href="/joytas9/Delete?id=<%=p.getId()%>" onclick="return confirm('id=<%=p.getId()%>を削除してよろしいですか？');">削除</a></td>

</tr>

<%} %>
</table>

<%} %>
</body>
</html>