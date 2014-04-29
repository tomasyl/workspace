<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>登入表单</h1>


	请输入使用者名称与密码：
	<p>
	<form action="j_spring_security_check" method="POST">
		用户名：<input type='text' name='j_username'> <br> 密 码：<input
			type='password' name='j_password'> <br> <input
			name="submit" type="submit"> <input name="reset" type="reset">
	</form>
	注意：输入错误会再回到这个页面中。
</body>
</html>