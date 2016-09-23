<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天天短租网，让我遇到你</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/Validform.js"></script>
<script src="/js/modernizr.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

input, select, textarea {
	font-size: 1em;
	margin: 0;
	color: #000;
	font-family: tahoma, arial, simsun, sans-serif;
	 border: 1px solid rgba(255,255,255,.4);
	 
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

:focus {
	outline: none;
}

body {
	font: 12px/1.5 tahoma, arial, \5b8b\4f53, sans-serif;
}
/* registerform */
.registerform .need {
	width: 10px;
	color: #b20202;
}

.registerform td {
	padding: 5px 0;
	vertical-align: top;
	text-align: left;
}

.registerform .inputxt, .registerform textarea {
	 border: 1px solid rgba(255,255,255,.4);
	width: 196px;
	padding: 2px;
}

.registerform textarea {
	height: 75px;
}

.registerform label {
	margin: 0 26px 0 10px;
}

.registerform .tip {
	line-height: 20px;
	color: #5f6a72;
}

.registerform select {
	width: 202px;
}

.registerformalter select {
	width: 124px;
}
/*==========以下部分是必须的===========*/
.Validform_checktip {
	margin-left: 8px;
	line-height: 20px;
	height: 20px;
	overflow: hidden;
	color: #999;
	font-size: 12px;
}

.Validform_right {
	color: #71b83d;
	padding-left: 20px;
	background: url(images/right.png) no-repeat left center;
}

.Validform_wrong {
	color: red;
	padding-left: 20px;
	white-space: nowrap;
	background: url(images/error.png) no-repeat left center;
}

.Validform_loading {
	padding-left: 20px;
	background: url(images/onLoad.gif) no-repeat left center;
}

.Validform_error {
	background-color: #ffe7e7;
}

#Validform_msg {
	color: #7d8289;
	font: 12px/1.5 tahoma, arial, \5b8b\4f53, sans-serif;
	width: 280px;
	background: #fff;
	position: absolute;
	top: 0px;
	right: 50px;
	z-index: 99999;
	display: none;
	filter: progid:DXImageTransform.Microsoft.Shadow(Strength=3, Direction=135,
		Color='#999999');
	-webkit-box-shadow: 2px 2px 3px #aaa;
	-moz-box-shadow: 2px 2px 3px #aaa;
}

#Validform_msg .iframe {
	position: absolute;
	left: 0px;
	top: -1px;
	z-index: -1;
}

#Validform_msg .Validform_title {
	line-height: 25px;
	height: 25px;
	text-align: left;
	font-weight: bold;
	padding: 0 8px;
	color: #fff;
	position: relative;
	background-color: #000;
}

#Validform_msg a.Validform_close:link, #Validform_msg a.Validform_close:visited
	{
	line-height: 22px;
	position: absolute;
	right: 8px;
	top: 0px;
	color: #fff;
	text-decoration: none;
}

#Validform_msg a.Validform_close:hover {
	color: #cc0;
}

#Validform_msg .Validform_info {
	padding: 8px;
	border: 1px solid #000;
	border-top: none;
	text-align: left;
}

.style1 {
	font-size: 22px;
	color: #FFFFFF;
}

.container {
    margin-left:auto;
    margin-right:auto;
    width: 500px;
    height: 400px;
    padding:30px;
    border: 1px solid rgba(0,0,0,.2);
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-background-clip: padding;
    -webkit-background-clip: padding-box;
    background-clip: padding-box;
    background: rgba(0, 0, 0, 0.5); 
    -moz-box-shadow: 0 0 13px 3px rgba(0,0,0,.5);
    -webkit-box-shadow: 0 0 13px 3px rgba(0,0,0,.5);
    box-shadow: 0 0 13px 3px rgba(0,0,0,.5);
    overflow: hidden; 
}

.style1 {
	font-size: 36px;
	color: #6666CC;
}

.style2 {
	color: #FFFFFF;
	font-size: 16px;
}
.btn {
	  width: 138px;
	  height: 44px;
	  -moz-border-radius: 4px;
	  -webkit-border-radius: 4px;
	  border-radius: 4px;
	  float:right;
      border: 1px solid #253737;
      background: #416b68;
      background: -webkit-gradient(linear, left top, left bottom, from(#6da5a3), to(#416b68));
      background: -webkit-linear-gradient(top, #6da5a3, #416b68);
      background: -moz-linear-gradient(top, #6da5a3, #416b68);
      background: -ms-linear-gradient(top, #6da5a3, #416b68);
      background: -o-linear-gradient(top, #6da5a3, #416b68);
      background-image: -ms-linear-gradient(top, #6da5a3 0%, #416b68 100%);
      padding: 10.5px 21px;
      -webkit-border-radius: 6px;
      -moz-border-radius: 6px;
      border-radius: 6px;
      -webkit-box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
      -moz-box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
      box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
      text-shadow: #333333 0 1px 0;
      color: #e1e1e1;
}

</style>
</head>

<body style="background-image:url(images/login_background.jpg)">
<h1><a href="index.html"><img src="images/logo(1).png" border="0"></a></h1>
<div class="container">
	<h2 align="center" class="h2 style1">用户注册</h2>
	<center>
	<form class="registerform" action="register.action"  name="register" method="post">
		<table width="100%" height="317" style="table-layout: fixed" action="ajax_post.php">
			<tr>
				<td width="10" height="67" class="need" style="width:10px;">*</td>
				<td width="70" style="font-size: 16px;
	color: #FFFFFF;">用户名：</td>
				<td width="232" style="width:205px;"><input type="text" value="" name="account_name" class="inputxt" datatype="s6-18"  nullmsg="请输入用户名！" errormsg="用户名6-18位,只能是字母,数字,下划线" /></td>
				<td width="758"><div class="Validform_checktip">用户名6-18位,只能是字母,数字,下划线</div></td>
			</tr>
			<tr>
				<td height="67" class="need">*</td>
				<td><span class="style2">密码：</span></td>
				<td><input type="password" value="" name="password" class="inputxt" datatype="*6-16" nullmsg="请输入密码！" errormsg="密码范围在6~16位之间,不能使用空格！" /></td>
				<td><div class="Validform_checktip">密码范围在6~16位之间,不能使用空格</div></td>
			</tr>
			<tr>
				<td height="80" class="need">*</td>
				<td><span class="style2">确认密码：</span></td>
				<td><input type="password" value="" name="repeatpassword" class="inputxt" datatype="*" recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" /></td>
				<td><div class="Validform_checktip">两次输入密码需一致</div></td>
			</tr>
			
	  </table>
	  <input name="submit" class="btn" type="submit" value="注册" />
	<h2 class="style6">已有账号？<a href="log.jsp">点此登录</a></h2>
	</form>
	
	</center>
</div>

	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/Validform.js"></script>
	<script type="text/javascript">
		$(function() {
			//提示效果二;
			$(".registerform:last").Validform({
				tiptype : 2,
				ajaxPost : true,
				callback : function(data) {
					if (data.status == "y") {
						setTimeout(function() {
							$.Hidemsg(); //公用方法关闭信息提示框;
						}, 2000);
					}
				}
			});

		})
	</script>
</body>
</html>