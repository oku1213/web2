<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
Cart cart = (Cart)session.getAttribute("cart");
String err = (String)request.getAttribute("err");
String msg = (String)request.getAttribute("msg");
%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>VegetableCart</title>
  </head>
  <body>
    
    <div class="container" style="margin-top:20px;">
    <p>商品をカートに入れてください</p>
    <% if(err != null){ %>
    <div class="alert alert-danger" role="alert">
    <%=err %>
     </div>
    <%} %>
    <% if(msg != null){ %>
    <div class="alert alert-success" role="alert">
   <%=msg %>
   </div>
   <%} %>
    <form action="/vegecart/Main" method="post">
    <div class="form-group">
    <label for="name">商品名:</label>
    <input type="text" name="name" style="width:200px;" class="form-control" id="name" placeholder="商品名を入力">
  </div>
  <div class="form-group">
    <label for="price">価格:</label>
    <input type="number" name="price" style="width:200px;" class="form-control" id="price" placeholder="価格を入力">
  </div>
  <button type="submit" class="btn btn-primary">カートに追加</button>
    </form>
    <% if(cart != null){ %>
    <div class="alert alert-secondary float right" role="alert">
    <%=String.format("合計：%,d円",cart.getTotal()) %>
    </div>
    
    <table class="table table-striped mt-4">
    <tr><th>商品名</th><th>価格</th>
			</tr>
    <% for(Vegetable v:cart.getList()){ %>
    <tr><th> <%=v.getName() %></th><td><%=String.format("%,d円", v.getPrice()) %></td></tr>
    <%} %>
    </table>
    <%} %>
    </div><!--  end container -->
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>