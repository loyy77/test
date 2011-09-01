<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="UsrServlet?op=login" method="post">
		<table border="1">
			<tr>
				<td colspan="3">欢迎登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" />
				</td>
				<td>message</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" />
				</td>
				<td>message</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /><input type="reset" />  	<a href="create.jsp">注册</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>