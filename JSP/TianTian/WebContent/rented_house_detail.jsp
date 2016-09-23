<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.google.gson.*"
	import="java.util.*"
	import="com.tiantian.dao.impl.*"
	import="com.opensymphony.xwork2.ActionContext"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title> 天天短租网，让我遇见你 </title>
        <link rel="stylesheet" type="text/css" href="css/detail_house_button.css" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/detail_house_page_location.css">
		<script src="js/jquery-1.7.1.min.js"></script>
		<script src="js/jquery.scrollTo-1.4.2-min.js"></script>
		<script src="js/waypoints.min.js"></script>
		<script src="js/navbar2.js"></script>
  <style type="text/css">
* {margin:0;padding:0;}
.container {
margin-left:230px;
margin-right:auto;
background-color:#FFFFFF;
width:68%;
height:340px;

}
.main_left{
	float:left;
	width:550px;
	heigth:320px;
	
	}

.pic{
	padding:10px;
	width:550px;
	}

.pic img{
	display:block;
	width:550px;
	height:320px;
	}	

.div_right{
	float:left;

	width:250px;
	height:340px;
	
	padding:50px;
}
.style2 {
	font-size: 24px;
	color: #FF9900;
	font-weight: bold;
}
  .style3 {font-size: 18px}
  
 .editbox{
    background: #ffffff;
    border: 1px solid #b7b7b7;
    color: #003366;
    cursor: text;
    font-family: "arial";
    font-size: 9pt;
    height: 18px;
    padding: 1px; 
}
#container_button{
	margin-left:115px;
	margin-right:auto;
	width:300px;
	height:18px;
}
.low_container{
margin-left:auto;
margin-right:auto;
background-color:#FFFFFF;
width:65%;
height:auto;

}
.img-circle{ 
width:60px; 
height:60px; 
border-radius:70px; 
} 
 
  .style6 {
	color: #FF9900;
	font-weight: bold;
	font-size: 20px;
}
  .style7 {color: #FF9933}
  </style>
 </head>
 
<body style="background-color:#d7e4e5">
<br><br><br>
<%ActionContext actionContext = ActionContext.getContext();
	Map sess = actionContext.getSession();
	JsonParser parse = new JsonParser();
	JsonArray array = parse.parse(sess.get("house_information_list").toString())
			.getAsJsonArray();
	JsonObject subObject = array.get(0).getAsJsonObject();
	%>
 <div class="container">
	<div class="main_left">

        <div class="pic">
            <img src="<%=subObject.get("Src"+0).toString().replace("\"", "") %>"/>
        </div>
    </div>
	
	
<div class="div_right">
	<form>
	<br>
	<li><span class="style2">￥</span>&nbsp;&nbsp;<span class="style4"><%=subObject.get("Price"+0).toString().replace("\"", "") %>元/晚</span></li>
	<br><br>
	<li class="style3"><%=subObject.get("Name"+0).toString().replace("\"", "") %></li>
	<br><br>
	<li><span class="style6">地址</span>:&nbsp;<%=subObject.get("Address"+0).toString().replace("\"", "") %></li>
	<br><br>
	<div id="container_button">
		<img src="images/heart.gif">
	 </div>
	 <br><br>
	 <span class="style7">(*≧▽≦*)欢迎您再次入住~~~</span>
	</div>
	</form>	
</div>
</div>
<br>
<div class="low_container">

<div class="wrapper">
  <div class="nav-container">
    <nav>
      <ul>
        <li><a href="#chapter-1" class="selected">房屋环境</a></li>
        <li><a href="#chapter-2">房屋描述</a></li>
        <li><a href="#chapter-3">我要评价</a></li>
      </ul>
      <div class="nav-left"></div>
      <div class="nav-right"></div>
      <div class="nav-above"></div>
    </nav>
  </div>
  <section id="chapter-1"> <img src="images/dino.jpg" />
    <div class="column">   
     <textarea name="surrounding" cols="98" rows="4" disabled="disabled"><%=subObject.get("Surrounding"+0).toString().replace("\"", "") %> </textarea>
    </div>
	<br>
    <hr />
  </section>
  
  <section id="chapter-2"> <img src="images/dino.jpg" />
    <div class="column">
     <textarea name="describe" cols="98" rows="4" disabled="disabled"><%=subObject.get("Others"+0).toString().replace("\"", "") %> </textarea>
    </div>
	<br>
    <hr />
  </section>
  
  <section id="chapter-3"> <img src="images/dino.jpg" />
    <div class="column">
		<img src="images/touxiang.png" class="img-circle">
		用户名：<%=sess.get("current_id").toString().replace("\"", "") %>
      <form action="add_comment.action?House_id=<%= subObject.get("House_id"+0).toString().replace("\"", "")%>" method="post">
      <textarea name="pingjia" cols="98" rows="4"> </textarea>
	  
	 <div align="center"><input name="upload_pingjia" type="submit" class="demo_five2" type="submit" value="提交评价"></div>
    </div>
    </form>
    <hr />
  </section>
  
</div>

</div>
</body>
</html>

