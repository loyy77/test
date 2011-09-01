<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<form action="UsrServlet?op=create" method="post">
<table border="1">

		<tr>
			
			<td>用户名</td>
			<td>密码</td>
		
		</tr>
	<tr>
			
			<td><input type="text" value="" name="username"/></td>
			<td><input type="text" value="" name="password"/></td>
			
		</tr>
	
			
		
	</table>
	<input type="submit" name="btncreate" value="create"/>
	</form>
</body>
</html>