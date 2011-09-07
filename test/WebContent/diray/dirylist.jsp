<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日记列表</title>

<style type="text/css">
h1 {
	color: Green;
}

body {
	background-color: #EEEEEE;
}

.list {
	background: #EEEEEE none repeat scroll 0 0;
	border-top: 1px solid #CCCCCC;
	padding: 5px 10px;
	width: 300px;
}

.del {
	color: Blue;
	display: block;
	float: right;
	width: 35px;
}

.cls {
	border: 1px solid red;
}
</style>

<script src="../js/jquery.js"></script>



</head>

<body>

	<table id="list" border=1>
		<tr>
			<td>编号</td>
			<td>标题</td>
			<td>内容</td>
			<td>发布日期</td>
			<td colspan=2>操作<a href="#">删除</a>
			</td>
		</tr>
	</table>


</body>
</html>
<script type="text/javascript">
	$(function() {
		$
				.ajax({
					type : "POST",
					url : '../DirayServlet',
					dataType : 'json',
					data : {
						op : 'readlist'
					},
					success : function(data, textStatus) {
						
						for (i in data) {
							
							$("#list")
									.append(
											"<tr><td>"
													+ data[i].id
													+ "</td><td>"
													+ (data[i].title)
													+ "</td><td>"
													+ (data[i].centent + "</td>")
													+ ("<td>"
															+ data[i].publishtime + "</td>")
													+ ("<td><a href='../DirayServlet?op=toupdate&id="
															+ data[i].id
															+ "' id="
															+ data[i].id + ">编辑</a></td>")
													+ ("<td><a id='del-"+data[i].id+"' class='del' href='#'>删除</a></td></tr>"));
						}//../DirayServlet?op=delete&id="+data[i].id+"

					}
				});

	});
</script>
<script type="text/javascript">
	$(function() {

		$(".del").live(
				'click',
				function() {

					var $p = $(this).parent().parent();
					var $this = $(this);
					if (!confirm("确认要删除，编号为："
							+ $this.attr("id").replace('del-', '') + " 的日记?")) {
						return false;
					}
					$.ajax({
						type : "post",
						url : "../DirayServlet",
						//得到id
						data : {
							id : $this.attr("id").replace('del-', ''),
							op : "delete"
						},
						beforeSend : function() {
							//发送请求前改变背景色
							$p.css("backgroundColor", "#FB6C6C");
						},
						success : function() {
							//删除成功
							$p.slideUp(300, function() {
								//移除父级div
								$p.remove();
							});
						}
					});
					//阻止浏览器默认事件
					return false;
				});
	});
</script>

