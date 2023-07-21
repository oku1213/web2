<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*" %>
<%
EJWord ejw = (EJWord)request.getAttribute("ejw");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EJword</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<link rel="stylesheet" href="/ejword/css/main.css">

</head>
<body>
<div class="container">
<form action="/ejword/main" method="get" class="form-inline">
<input type="text" name="searchWord" value="<%=ejw.getSearchWord() %>" class="form-control" placeholder="検索語を入力" required>
<select name="mode" class="form-control">
<option value="startsWith" <%=ejw.getMode().equals("startsWith")? "selected":"" %>>で始まる</option>
<option value="contains" <%=ejw.getMode().equals("contains")? "selected":"" %>>を含む</option>
<option value="endsWith" <%=ejw.getMode().equals("endsWith")? "selected":"" %>>で終わる</option>
<option value="match" <%=ejw.getMode().equals("match")? "selected":"" %>>と一致する</option>
</select>
<button type="submit" class="btn btn-primary">検索</button>
</form>
<% if(ejw.getList() != null && ejw.getList().size()==0){ %>
<p>1件も一致しませんでした</p>
<%} %>

<% if(ejw.getList() != null && ejw.getList().size() >0){ %>


<%-- 件数表示部分作成 --%>
<% if(ejw.getTotal() <= ejw.getLimit()) {%>
<p>全<%=ejw.getTotal() %>件</p>
<%}else{ %>
<p>全<%=ejw.getTotal() %>件中 <%=(ejw.getPageNo()-1)*ejw.getLimit()+1 %>～<%= ejw.getPageNo() * ejw.getLimit() > ejw.getTotal()? ejw.getTotal():ejw.getPageNo()*ejw.getLimit() %>件を表示</p>
<ul class="pager">
<%if(ejw.getPageNo() > 1){ %>
<li><a href="/ejword/main?searchWord=<%=ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=ejw.getPageNo()-1 %>"><span>&larr;</span>前へ</a></li>
<%} %>
<%if(ejw.getPageNo()*ejw.getLimit() < ejw.getTotal()){ %>
<li><a href="/ejword/main?searchWord=<%=ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=ejw.getPageNo()+1 %>"><span>&rarr;</span>次へ</a></li>
<%} %>
</ul>

<%} %>
<table class="table table-bordered table-striped">
<%for(Word w :ejw.getList()){ %>
<tr><th><%=w.getTitle() %></th><td><%=w.getBody() %></td></tr>
<%} %>
</table>
<%} %>
<%if(ejw.getPager() != null){ %>
<div class='paginationBox'>
<ul class='pagination'>
<% for(String[] row:ejw.getPager()){ %>
<li class="<%=row[0] %>">
<a href="/ejword/main?searchWord=<%= ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=row[1] %>">
<%=row[2] %></a>
</li>
<%} %>
</ul>
</div>
<%} %>
</div><!-- end container -->
<footer>
&copy; 2023 Joytas.net
</footer>
</body>
</html>