<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.tiantian.model.*" import="java.util.*"
	import="com.opensymphony.xwork2.ActionContext"  
	import="com.google.gson.*"
	isELIgnored="false"%>
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/detail_house_button.css" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/detail_house_page_location.css">
		<script src="js/jquery-1.7.1.min.js"></script>
		<script src="js/jquery.scrollTo-1.4.2-min.js"></script>
		<script src="js/waypoints.min.js"></script>
		<script src="js/navbar2.js"></script>
<title>天天短租网-让我遇见你</title>

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
	color: #000000;
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
  </style>

</head>
<body style="background-color:#d7e4e5">
<br><br><br>
<%     
    ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();

		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("house_information_list").toString())
				.getAsJsonArray();
		JsonArray array2=parse.parse(sess.get("comment_list").toString()).getAsJsonArray();

%>	
<%JsonObject subObject = array.get(0).getAsJsonObject();%>
 <div class="container">
	<div class="main_left">

        <div class="pic">
			<img src="<%=subObject.get("Src" + i).toString().replace("\"", "").replace("\\", "/")%>"/>
        </div>
    </div>
    
 
<div class="div_right">
	<form action="insert_rent_list.action?house_id=<%=subObject.get("House_id"+i).toString().replace("\"", "") %>" method="post">
	
	<%!int i=0; %>
	<li><span class="style2">￥</span><%=subObject.get("Price" + i).toString().replace("\"", "") %>元/晚</li>
	<br>
	<li class="style3"><%=subObject.get("Master" + i).toString().replace("\"", "") %></li>
	<br>
	<li>地址:<%=subObject.get("Address" + i).toString().replace("\"", "") %></li>
	<br>
	<li>入住日期:<input  class="editbox" name="inhouse" type="text"></li>
	<br>
	<li>退房日期:<input  class="editbox" name="outhouse" type="text"></li>
	<br>
	<div id="container_button">
		<img src="images/heart.gif">
	 </div>
	 <div align="center"><input name="cute_button"  class="demo_five" type="submit" value="立即预定"></div>
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
        <li><a href="#chapter-3">用户评价</a></li>
      </ul>
      <div class="nav-left"></div>
      <div class="nav-right"></div>
      <div class="nav-above"></div>
    </nav>
  </div>
  <section id="chapter-1"> <img src="images/dino.jpg" />
    <div class="column">   
     <textarea name="surrounding" cols="98" rows="4" disabled="disabled"><%=subObject.get("Surrounding"+i).toString().replace("\"", "") %> </textarea>
    </div>
	<br>
    <hr />
  </section>
  
  <section id="chapter-2"> <img src="images/dino.jpg" />
    <div class="column">
     <textarea name="describe" cols="98" rows="4" disabled="disabled"><%=subObject.get("Others"+i).toString().replace("\"", "") %></textarea>
    </div>
	<br>
    <hr />
  </section>
  
  <section id="chapter-3"> <img src="images/dino.jpg" />
  	
    <div class="column">
	<%  for(int i=0;i<array2.size();i++){
  		JsonObject subObject2 = array2.get(i).getAsJsonObject();
  		%>
		<img src="images/touxiang.png" class="img-circle">
		用户名： <%=subObject2.get("User_id"+i).toString().replace("\"", "") %>
      <textarea name="pingjia" cols="98" rows="4" disabled="disabled"> <%=subObject2.get("Comment"+i).toString().replace("\"", "").replace("\\", "/") %></textarea>
	  
	   <%
  	}
  	
  	%>
    </div>
   
    
    <hr />
  </section>
  
</div>

</div>
</body>
</html>