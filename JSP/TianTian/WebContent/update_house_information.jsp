<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page  import="com.tiantian.model.*" import="java.util.*" 
	import="com.opensymphony.xwork2.ActionContext"
	import="com.google.gson.*"
	isELIgnored="false"%>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天短租网-让我遇见你</title> 
</head>
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  
<style>
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
}

body {
	font: 12px/1.5 tahoma, arial, \5b8b\4f53, sans-serif;
}

.div_container {
	width: 720px;
	background: #F1F1F1;
	margin: 20px auto;
	padding: 10px;
	heigth: 2500px;
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
	color: #6699CC;
	font-family: "方正兰亭超细黑简体";
	font-size: 24px;
}
/* === Button Style === */
.btn-wrap {
	text-align: center;
	margin: 50px;
}
.btn{
  position: relative;
  display: inline-block;
  line-height: 25px;
  padding: 5px 15px;
	margin:10px;
	transition: all .3s ease-out;
  text-transform: uppercase;
  border-radius: 5px;
  border: 1px solid #1e639a;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
  text-shadow:0 1px 2px rgba(0,0,0,.4);
  box-shadow: inset 1px 0 0  #559ad5,inset -1px 0 0  #559ad5,inset 0 1px 0  #559ad5,inset 0 -1px 0  #559ad5,0 0 1px rgba(0,0,0,0.5);
  background: #4086c2; /* Old browsers */
  background: -*-linear-gradient(to bottom,  #4086c2 0%,#2989d8 100%,#3378b1 100%); 
}
.btn:hover {
  background: #3378b1; /* Old browsers */
  background: -*-linear-gradient(to bottom,  #3378b1 0%,#2989d8 0%,#4086c2 100%); 
}
.btn:active:after {
  content: "";
  display:block;
  width: 2px;
  height: 2px;
  position:absolute;
  border-radius:2px;
  top:50%;
  left: 50%;
  margin: -1px 0 0 -1px;
  z-index:2;
  background: rgba(255,255,255,1);
  box-shadow:0 0 10px 5px rgba(255,255,255,0.5),
    0 0 20px 10px rgba(255,255,255,0.5),
    0 0 30px 15px rgba(255,255,255,0.4),
    0 0 40px 20px rgba(255,255,255,0.3),
    0 0 50px 25px rgba(255,255,255,0.3),
    0 0 60px 30px rgba(255,255,255,0.3),
    0 0 70px 35px rgba(255,255,255,0.3);
}​
</style>
 
  
<body>

<body>
	<%     
    ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();

		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("current_house_informaton").toString())
				.getAsJsonArray();
		    int i=0;
			JsonObject subObject = array.get(i).getAsJsonObject();
	%>

	<div class="div_container">
		<form class="registerform" action="update_house_information.action?House_id=<%=subObject.get("House_id"+0).toString().replace("\"", "") %>" method="post"
			enctype="multipart/form-data" name="upload_house">
			<h1 align="center" class="style1">修改房屋</h1>
			<table width="100%" style="table-layout: fixed" action="ajax_post.php">
	 		
  
			
			<tr>
				<td class="need">*</td>
				<td style="width:70px;">房屋名称: </td>
				<td><input type="text"  id="1" name="title_textfield" value=<%=subObject.get("Name" + i).toString().replace("\"", "") %>
					style="width:150px" placeholder="如钟楼旁海景大床房" datatype="mz" nullmsg="请输入房屋名称！"
					errormsg="请输入房屋名称！" disabled="disabled"/></td>
				<td><div class="Validform_checktip"></div></td>
			</tr>
			<br>
				
			
		        <tr>
				<td class="need">*</td>
				<td style="width:70px;">地址详情: </td>
				<td>
				<input type="text" name="address" id="2" style="width:350px"
					placeholder=" 如长安区西安邮电大学东区2号公寓xx宿舍" datatype="zw" nullmsg="此处不能为空！"
					errormsg="请输入详细地址！" disabled="disabled" value=<%=subObject.get("Address" + i).toString().replace("\"", "") %>></td>
				<td><div class="Validform_checktip" style="margin-left:370pxt;"></div></td>
				</tr>
				
				<tr>
				<td class="need">*</td>
				<td style="width:70px;">房屋面积: </td>
				<td><input type="text" name="housearea"  id="3" class="contact_form textarea" style="width:100px"
					value=<%=subObject.get("Area" + i).toString().replace("\"", "") %>
					placeholder=" 请填写数字" datatype="number" nullmsg="此空不能为空！"
					errormsg="输入错误！" disabled="disabled"/>平方米</td>
				<td><div class="Validform_checktip"></div></td>
				<td></td>
				</tr>
				
				<tr>
				<td class="need">*</td>
				<td style="width:70px;">价格要求: </td>
				<td><input type="text" name="dayprice"  id="4" placeholder=" 请填写数字" style="width:100px" datatype="number" nullmsg="此空不能为空！"
					errormsg="输入错误！"  value=<%=subObject.get("Price" + i).toString().replace("\"", "") %>  disabled="disabled"/>元每天</td>
				<td><div class="Validform_checktip"></div></td>
				<td></td>
				</tr>
				
				<tr>
				<td class="">*</td>
				<td style="width:70px;">环境: </td>
				<td><textarea name="surrounding" id="5" style="width:300px;height:150px;" cols="40" rows="6"
					placeholder=" 请填写环境信息"   disabled="disabled"><%=subObject.get("Surrounding" + i).toString().replace("\"", "") %></textarea></td>
				</tr>
				
				<tr>
				<td class="">*</td>
				<td style="width:70px;">其他说明: </td>
				<td><textarea name="othermessage" id="6" style="width:300px;height:150px;" cols="40" rows="6"
					placeholder=" 请填写特殊说明"  disabled="disabled"><%=subObject.get("Others" + i).toString().replace("\"", "") %></textarea></td>
				</tr>
				
				<tr>
				<td class="">*</td>
				<td style="width:70px;"> 上传图片: &nbsp; &nbsp; &nbsp;</td>
				<td><input type="file" name="photo"></td>
				</tr>			
				
				<tr>
				<td class="need"></td>
				<td></td>
				<td></td>
				<td colspan="3" style=";">
				<button class="btn" type="button" name="xiugai_button" onclick="check()">修改</button>
				<button class="btn" type="submit" name="upload_button">提交</button></td>			
					</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/Validform(1).js"></script>
	<script type="text/javascript" src="js/city.js"></script>
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
		
	function check()
{

document.getElementById("1").disabled = false;
document.getElementById("2").disabled = false;
document.getElementById("3").disabled = false;
document.getElementById("4").disabled = false;
document.getElementById("5").disabled = false;
document.getElementById("6").disabled = false;

}	
		
	</script>
</body>

</body>
</html>