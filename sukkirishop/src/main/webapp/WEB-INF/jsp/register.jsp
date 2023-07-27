<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店ユーザー登録画面</title>
</head>
<body>
<h1>ユーザー登録画面</h1>
<form action="RegisterServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type ="password" name="pass"><br>
<input type ="submit" value="新規登録">
</form>
</body>
</html>