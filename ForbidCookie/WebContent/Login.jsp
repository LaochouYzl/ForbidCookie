<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
</head>
<body>
	<form action="user" method="post">
		<input type="hidden" name="method" value="login">
		用户名: <input type="text" name="userName"><br>
		密   码: <input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>