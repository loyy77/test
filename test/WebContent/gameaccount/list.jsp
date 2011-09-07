<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏帐号列表</title>
<script src="../js/jquery.js"></script>

</head>
<body>
	<table width="740" height="36" border="1" id="tab" name="tab">
		<tr>
			<th height="30" scope="col">编号</th>
		  <th scope="col">游戏名</th>
			<th scope="col">登录帐号</th>
			<th scope="col">登录密码</th>
			<th scope="col">备注</th>
			<th scope="col">操作</th>
		</tr>
	</table>
</body>
</html>

<script type="text/javascript">
	$(function() {

		$
				.ajax({
					type : "POST",
					url : "../game",
					dataType : 'json',
					data : {
						op : 'readlist'
					},
					success : function(data, textStatus) {

						for (i in data) {

							$("#tab")
									.append(
											"<tr><td>"
													+ data[i].id
													+ "</td><td>"
													+ data[i].name
													+ "</td><td>"
													+ data[i].loginname
													+ "</td><td>"
													+ data[i].loginpwd
													+ "</td><td>"
													+ data[i].mark
													+ "</td><td align='center'><a href='#'>编辑</a> <a href='#'>删除</a>"
													+ "</td></tr>");
						}

					}

				});
	});
</script>