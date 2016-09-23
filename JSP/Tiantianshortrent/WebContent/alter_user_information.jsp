<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<script src="js/jquery-2.0.0.jsz/jquery-2.0.0.min.js"></script>
<script src="js/add_information_test.js"></script>
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

.phone_error {
	color: red;
	padding-left: 10px;
}
</style>
</head>

<body background="images/login_background.jpg">
	<h1>
		<a href="index.html"><img src="images/logo(1).png" border="0"></a>
	</h1>
	<div class=form1>
		<form action="updata_user_information.action" method="post">
			<li class="style1 style2">修改个人信息</li> <br> <span class="style1">姓名:</span>
			<input name="name" type="text" maxlength="20"> <br> <br>
			<br> <span class="style1">性别:</span><span class="style1">男</span>
			<input type="radio" value="男" checked="checked" name="sex" /> <span
				class="style1">女</span> <input type="radio" value="女" name="sex">
			<br> <br> <br> <span class="style1">出生日期：</span> <select name="Y">
				<script>
					for (var i = 2015; i >= 1970; i--) {
						document.write("<option value='"+i+"'>" + i
								+ "</option>");
					}
				</script>
			</select> 年 <select name="M">
				<script>
					for (var i = 12; i >= 1; i--) {
						document.write("<option value='"+i+"'>" + i
								+ "</option>");
					}
				</script>
			</select> 月 <select name="D">
				<script>
					for (var i = 31; i >= 1; i--) {
						document.write("<option value='"+i+"'>" + i
								+ "</option>");
					}
				</script>
			</select> 日 <br> <br> <br> <span class="phone">手机号:</span> <input
				name="telephone" type="text" size="20" /> <span class="phone_error">电话号码只能包含数字</span>
			<br> <br> <input name="submit_tijiao" class="btn"
				type="submit" value="提交" />
		</form>
	</div>
	<script>
$(document).ready(function(){
$('.phone_error').hide();
$('.btn').click(function(event){
	var data=$('.phone').val();
	if(validate_phoneno(data))
	{
		$('.phone_error').hide();
		alert("修改成功，点击返回");
	}
	else
	{
		$('.phone_error').show();
		event.preventDefault();
	}
 });
});
function validate_phoneno(ph)
{
	var pattern=new RegExp(/^[0-9-+]+$/);
	return pattern.test(ph);
}
</script>
</body>
</html>
