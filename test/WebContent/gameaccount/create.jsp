<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//上个页面传来的参数：flag，如果flag=0，清空文本框（添加界面）；flag=1，更改界面。添加和更新功能使用了同一个界面。
	if (request.getParameter("flag") != null) {
		session.setAttribute("flag",
				new Integer(request.getParameter("flag")));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建游戏账户信息</title>

<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {

		var flag = $('#flag').val();
		if (flag == 1) {
			$("#btnSubmit").val("确认修改");
		}
		if (flag == 0) {
			$("input[type='text']").val("");
			$("textarea[name='mark']").val("");
		}

	});
</script>
</head>
<body>



	<a href="list.jsp?uid=${usr.id }">查看游戏帐号</a>
	<form action="../game" id="form1">
		<input type="hidden" name="flag0" id="flag0" value="${f}" /> <input
			type="hidden" name="flag" id="flag" value="${flag}" /> <input
			type="hidden" name="id" value="${ga.id}" />



		<table>


			<tr>
				<td>游戏名</td>
				<td><input type="text" name="gamename" value="${ga.name }" />
				</td>
			</tr>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="loginname"
					value="${ga.loginname }" /></td>
			</tr>
			<tr>
				<td>登录密码</td>
				<td><input type="text" name="loginpwd" value="${ga.loginpwd }" />
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td><textarea name="mark">${ga.mark }</textarea></td>
			</tr>
			<tr>
				<td colspan=2><input name="btnSubmit" id="btnSubmit"
					type="submit" value="发表" />&nbsp;<input id="reset" type="reset" />
				</td>
			</tr>
		</table>

	</form>


</body>
</html>

<script type="text/javascript">
	$('#form1')
			.submit(
					function(event) {
						//	alert("d："+$(this).find('input[name="gamename"]').val());
						//event.preventDefault();
						//	alert($(this).attr("action"));
						//

						//alert("action:"+$(this).attr("action"));
						//alert("gamename:"+$(this).find('input[name="gamename"]').val());
						///alert("loginname"+$(this).find('input[name="loginname"]').val());
						//alert("loginpwd"+$(this).find('input[name="loginpwd"]').val());
						//alert("mark"+$(this).find('textarea[name="mark"]').val());
						event.preventDefault();

						var $form = $(this), url = $form.attr("action"), gamen = $form
								.find('input[name="gamename"]').val(), loginn = $form
								.find('input[name="loginname"]').val(), loginp = $form
								.find('input[name="loginpwd"]').val(), mar = $form
								.find('textarea[name="mark"]').val(), flag = $form
								.find('input[name="flag"]').val(), o = "create", i = $form
								.find('input[name="id"]').val();

						if (flag == 1) {
							o = "update";

						}
						$.post(url, {
							op : o,
							gamename : gamen,
							loginname : loginn,
							loginpwd : loginp,
							mark : mar,
							id : i
						}, function(data) {
							window.location = "../frame_right.html";
						});

						//alert(url);

					});
</script>