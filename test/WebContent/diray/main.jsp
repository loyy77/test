<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的日记</title>

<script src="../js/jquery.js"></script>

</head>
<body>
<a href="dirylist.jsp?uid=${usr.id}" target="centent">查看日记</a>
	<form action="../DirayServlet" id="form1">
		<table>
			<tr>
				<td style="width: 60px;">标题</td>
				<td style="width: 415px;"><input name="title" id="title"
					style="width: 217px;">
				</td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea name="centent" id="centent"
						style="height: 133px; width: 438px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input id="btnSubmit" type="submit" value="发表" />
				</td>
			</tr>
		</table>
		<div id="result"></div>
	</form>
	
	
<script type="text/javascript">
//捕获提交事件，向serevlet发送请求，以发表日记
	$('#form1').submit(function(event){
	
		event.preventDefault(); 
		
		var $form=$(this),
		url=$form.attr("action"),
		tit=$form.find('input[name="title"]').val(),
		cent=$form.find('textarea[name="centent"]').val(),
		o="create";
		//alert($form);
		$.post(url,{op:o,title:tit,centent:cent},function(data){
			window.location="../frame_right.html";
		});
	});
</script>
</body>
</html>