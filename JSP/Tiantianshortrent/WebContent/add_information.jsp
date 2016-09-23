<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天短租网-让我遇见你</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

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
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	cellpadding:30px;
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
	border: 1px solid #a5aeb6;
	width: 200px;
	padding: 5px;
}

.registerform textarea {
	height: 80px;
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

.Validform_checktip {
	margin-left: 8px;
	line-height: 20px;
	height: 20px;
	overflow: hidden;
	color: #999;
	font-size: 14px;
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

.formcontainer{
    margin-left:auto;
    margin-right:auto;
    width: 600px;
    height: auto;
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

.btn{

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

.style2 {
	color: #6699CC;
	font-size: 32px;
	font-family: "方正兰亭超细黑简体";
}
.style3 {
	color: #FFFFFF;
	font-size: 16px;
	font-weight: bold;
}
</style>
</head>


<body background="images/login_background.jpg">
	<h1><a href="index.html" ><img src="images/logo(1).png" border="0"></a></h1>
	<div class="formcontainer" >
	<center>
	
	<h2 class="style2">您是新用户，请补全信息</h2>
	<br>
	<form class="registerform" action="add_information.action " method="post">
		<table width="58%" style="table-layout: fixed; action="ajax_post.php">
			<tr>

				<td width="56" height="44" class="need" style="width: 10px;">*</td>
				<td width="68" style="width: 70px;"><span class="style3">姓名：</span></td>
				<td width="203" style="width: 205px;"><input type="text" value=""
					name="name" class="inputxt" ajaxurl="valid.php"  nullmsg="请输入名字！"
					errormsg="昵称至少2个字符,最多10个字符！" /></td>
				<td width="284"><div class="Validform_checktip">姓名至少2个字符,最多10个字符</div></td>
			</tr>
			<tr>
				<td height="40" class="need" style="width: 5px;">*</td>
				<td style="width: 70px;"><span class="style3">出生日期：</span></td>
				<td colspan="3">

						<select name="optionY" style = "width:55px">
							<script>
								for (var i = 2015; i >= 1970; i--) {

									document.write("<option value='"+i+"'>" + i
											+ "</option>");
								}
							</script>
						</select>年
				
						<select name="optionM" style = "width:55px">
							<script>
								for (var i = 12; i >= 1; i--) {
									document.write("<option value='"+i+"'>" + i
											+ "</option>");
								}
							</script>
						</select>月
					
						<select name="optionD" style = "width:55px">
							<script>
								for (var i = 31; i >= 1; i--) {
									document.write("<option value='"+i+"'>" + i
											+ "</option>");
								}
							</script>
						</select>日
		  </div>
					
				</td>
			<td height="31"></tr>
			<tr>
				<td height="40" class="need"></td>
				<td><span class="style3">Email：</span></td>
				<td><input type="text" value="" name="email" class="inputxt" 
					datatype="e" ignore="ignore" 
					errormsg="请输入您常用的邮箱！" /></td>
				<td><div class="Validform_checktip">请输入您常用的邮箱</div></td>
			</tr>
			<tr>
				<td height="40" class="need">*</td>
				<td><span class="style3">手机号：</span></td>
				<td><input type="text" value="" name="telephone" class="inputxt"
					datatype="m" errormsg="请输入您的手机号码有误！" /></td>
				<td><div class="Validform_checktip"></div></td>
			</tr>
			<tr>
				<td height="40" class="need">*</td>
				<td><span class="style3">身份证：</span></td>
				<td><input type="text" value="" name="id_card" class="inputxt"
					datatype="i" errormsg="请输入身份证号有误！" /></td>
				<td><div class="Validform_checktip"></div></td>
			</tr>
			<tr>
				<td height="40" class="need">*</td>
				<td><span class="style3">性别：</span></td>
				<td><input type="radio" value="男" name="sex" id="male"
					class="pr1" datatype="radio" errormsg="请选择性别！" /><label for="male"><span class="style3">男</span></label>
					<input type="radio" value="女" name="sex" id="female" class="pr1" /><label
					for="female"><span class="style3">女</span></label></td>
				<td><div class="Validform_checktip"></div></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="need"></td>
				<td></td>
				<td colspan="2" style="padding: 10px 0 18px 0;"><input name="submit" class="btn"
					type="submit" value="提 交" onClick="JavaScript: return chk_search();" /> 
			</tr>
		</table>
	</form>
	</center>
</div>

	
	<script type="text/javascript" src="js/Validform.js"></script>
	<script type="text/javascript">
		$(function() {
			
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
		
	
 function chk_search()
 {
    alert('提交成功!')
    }


	</script>
</body>

</html>