<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
</head>
<body>
	<div class="content">
		<ul>
			<li><a href="<%=response.encodeURL("user?method=buy&name=Java&price=100") %>">Java书籍购买</a></li>
			<li><a href="<%=response.encodeURL(request.getContextPath()+"/user?method=buy&name=Python&price=90") %>">Python书籍购买</a></li>
			<li><a href="<%=response.encodeURL(request.getContextPath()+"/user?method=buy&name=Web&price=110") %>">WEB书籍购买</a></li>
		</ul>
	</div>
</body>
</html>