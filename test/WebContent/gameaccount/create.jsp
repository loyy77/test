<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建游戏账户信息</title>

<script src="../js/jquery.js"></script>
</head>
<body>
<a href="list.jsp?uid=${usr.id }">查看游戏帐号</a>
<form action="../game" id="form1">


	<table>
		<tr>
			<td>游戏名</td><td><input type="text" name="gamename"/></td>
		</tr>
		<tr>
			<td>登录名</td><td><input type="text" name="loginname"/></td>
		</tr>
		<tr>
			<td>登录密码</td><td><input type="text" name="loginpwd"/></td>
		</tr>
		<tr>
			<td>备注</td><td><textarea name="mark"></textarea></td>
		</tr>
		<tr><td colspan=2><input id="btnSubmit" type="submit" value="发表"/>&nbsp;<input id="reset" type="reset"/></td></tr>
	</table>
	
</form>

${usr.id }
</body>
</html>

<script type="text/javascript">


	$('#form1').submit(function(event){
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
		
		var $form=$(this),
		url=$form.attr("action"),
		gamen=$form.find('input[name="gamename"]').val(),
		loginn=$form.find('input[name="loginname"]').val(),
		loginp=$form.find('input[name="loginpwd"]').val(),
		mar=$form.find('textarea[name="mark"]').val();
	
		
		//alert(url);
		
		$.post(url,{op:"create",gamename:gamen,loginname:loginn,loginpwd:loginp,mark:mar},function(data){
			window.location="../frame_right.html";
		});
	});
</script>