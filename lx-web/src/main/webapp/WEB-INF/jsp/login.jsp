<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>登入表单</h1>


	请输入使用者名称与密码：
	<p>
		<form:form>  
用户名：<form:input path="userName" />
			<br>  
密 码：<form:password path="password" />
			<br>  

		
			<input type="submit" value="login" name="testSubmit" />
			<input type="reset" value="重置" />
		</form:form>
		注意：输入错误会再回到这个页面中。
</body>
</html>