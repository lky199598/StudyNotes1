<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8" />
<title>天天短租网-让我遇见你</title>
<link href="css/user_view_top.css" rel="stylesheet" type="text/css" />
</head>
<style>
.center {
	text-align: center;
}

.form1 {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: 560px;
	padding: 30px;
	border: 1px solid rgba(0, 0, 0, .2);
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	-moz-background-clip: padding;
	-webkit-background-clip: padding-box;
	background-clip: padding-box;
	background: rgba(0, 0, 0, 0.5);
	-moz-box-shadow: 0 0 13px 3px rgba(0, 0, 0, .5);
	-webkit-box-shadow: 0 0 13px 3px rgba(0, 0, 0, .5);
	box-shadow: 0 0 13px 3px rgba(0, 0, 0, .5);
	overflow: hidden;
}
</style>

<body background="images/user_view_background.jpg" center>
	<h1>
		<a href="index.html"><img src="images/logo(1).png" border="0"></a>
	</h1>
	<div class="center">
		<nav>
		<ul class="clear">
			<li class="first"><a href="manage_user.action">用户管理</a></li>
			<li><span class="Darrow"></span> <a href="#">订单管理</a>
				<dl>
					<dt>
						<span class="arrow"></span>
					</dt>
					<dd>
						<a href="#">我自己的房屋</a>
					</dd>
					<dd>
						<a href="#">我租赁的房屋</a>
					</dd>
				</dl></li>

			<li><a href="#">呵呵</a></li>
			<li><a href="#">信息管理</a></li>
			<li><a href="#">修改密码</a></li>
			<li class="last"><a href="#">-3-</a></li>
		</ul>
		</nav>
	</div>
	<form class="form1"></form>
</body>
</html>
