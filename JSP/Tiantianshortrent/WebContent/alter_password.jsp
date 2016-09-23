<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>天天短租网-让我遇见你</title>
<link href="css/register_style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/register_test.js"></script>
<style>
.form1 {
	margin-left: auto;
	margin-right: auto;
	width: 360px;
	height: 380px;
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

.btn {
	width: 138px;
	height: 44px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
	float: right;
	border: 1px solid #253737;
	background: #416b68;
	background: -webkit-gradient(linear, left top, left bottom, from(#6da5a3),
		to(#416b68));
	background: -webkit-linear-gradient(top, #6da5a3, #416b68);
	background: -moz-linear-gradient(top, #6da5a3, #416b68);
	background: -ms-linear-gradient(top, #6da5a3, #416b68);
	background: -o-linear-gradient(top, #6da5a3, #416b68);
	background-image: -ms-linear-gradient(top, #6da5a3 0%, #416b68 100%);
	padding: 10.5px 21px;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: rgba(255, 255, 255, 0.1) 0 1px 0, inset
		rgba(255, 255, 255, 0.7) 0 1px 0;
	-moz-box-shadow: rgba(255, 255, 255, 0.1) 0 1px 0, inset
		rgba(255, 255, 255, 0.7) 0 1px 0;
	box-shadow: rgba(255, 255, 255, 0.1) 0 1px 0, inset
		rgba(255, 255, 255, 0.7) 0 1px 0;
	text-shadow: #333333 0 1px 0;
	color: #e1e1e1;
}

.style1 {
	font-size: 22px;
	color: #FFFFFF;
}

.style2 {
	color: #0066CC;
	font-family: "方正兰亭超细黑简体";
}

.phone {
	font-size: 22px;
	color: #FFFFFF;
}

.password_error {
	color: red;
	padding-left: 10px;
}
</style>
</head>

<body background="images/login_background.jpg">
	<!-- <h1>
		<a href="index.html"><img src="images/logo(1).png" border="0"></a>
	</h1> -->
	<br><br><br><br>
	<div >
	<form action="updata_password.action" method="post">
		<li class="style1 style2">修改密码</li> <br> <input
			name="oldpassword" placeholder="请输入原密码" class="oldpassword"
			type="password" required /> <br> <input name="newpassword"
			placeholder="请输入新密码" class="repeatpassword" type="password" required>
		<br> <input name="repeatnewpassword" placeholder="请再次输入新密码"
			class="repeatpassword1" type="password" required> <span
			class="password_error">两次输入密码不一致</span> <br> <input
			name="submit_tijiao" class="btn" type="submit" value="提交" />
	</form>
	</div>

</body>
<script>
	$(document).ready(function() {
		$('.password_error').hide();
		$('.btn').click(function(event) {
			data = $('.repeatpassword').val();
			var len = data.length;
			if ($('.repeatpassword').val() != $('.repeatpassword1').val()) {
				$('.repeatpassword1').next().show();
			} else {
				$('.repeatpassword1').next().hide();
				alert("修改成功，点击返回");
				
			}
			
		});
	});
	
	
	
</script>
</html>
