<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  import="com.opensymphony.xwork2.ActionContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page import="com.tiantian.model.*" import="java.util.*" 
	import="com.opensymphony.xwork2.ActionContext"
	import="com.google.gson.*"
	isELIgnored="false"%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>天天短租网-让我遇见你</title>
<link href='http://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css'>
<link href="css/index_styles.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<style type="text/css">
<!--
.style2 {
	font-family: "Times New Roman", Times, serif
}

-->
.search_container{
 	margin-left:auto;
    margin-right:auto;
    width: 65%;
    height: 30px;
	padding:20px;
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

.btn {
	  width: 62px;
	  height: 35px;
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
.style3 {font-size: 10px}
}
</style>
</head>
<body>
	<%
		ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();
		String str=null;   
		if(sess.get("current_id")!=null){
			str=sess.get("current_id").toString();
		}
		
	%>
	<header>
	<div class="headerContainer">
		<!-- <h1 class="index_title">天天短租网</h1> -->
		<h1><a href="index.html"><img src="images/logo(1).png" border="0"></a></h1>
		<div id="navcontainer">
			<ul id="navlist">
				<li id="active"><a href="index.html">主页</a></li>
				<li><a href="user_view_hole.htm">尊敬的<%=str %>欢迎您</a></li>
				<li><a href="index.html">注销</a></li>
				<li><a href="log.jsp">切换用户</a></li>
				<li><a href="about.jsp">联系我们</a></li>
			</ul>
		</div>
		<br class="clearfloat" />
		<!-- begin .slider -->
		<div class="slider">
			<div class="flexslider">
				<ul class="slides">
					<li><img src="images/index_bg1.jpg" alt="" class="shadowStyle"></li>
					<li><img src="images/index_bg2.jpg" alt="" class="shadowStyle"></li>
					<li><img src="images/index_bg3.jpg" alt="" class="shadowStyle"></li>
				</ul>
			</div>
		</div>
		<br class="clearfloat" />
		<!-- end .slider -->
	</div>
	</header>


	<br>
<div class="container">

   <div class="search_container">
   <form action="search_view_1.htm" method="post">
   <div>
  	<input placeholder="您想住哪里？" type="text" name="location_search" class="location"/>
	<input placeholder="入住日期" type="text" name="ruzu_date" class="indate" />
	<input placeholder="退房日期" type="text" name="tuifang_date" class="outdate" />
	<input name="submit_search" class="btn" type="submit" value="搜索" />
   </div>
   </form>
   </div>
        <h1 align="center">Welcome to tiantian short-term rent </h1>
</div>

<div id="main">
 <%    
		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("show_house_list").toString())
				.getAsJsonArray();
		for (int i = 0; i < array.size(); i++) {
			if(i==8){
				break;
			}
			JsonObject subObject = array.get(i).getAsJsonObject();
 %>
 		<div id="main_pic">
			<div class="pic">
<a href="house_information.action?house_id=<%=subObject.get("House_id"+i).toString().replace("\"", "")%>&index=query"><img src="<%=subObject.get("Src" + i).toString().replace("\"", "").replace("\\", "/") %>"/></a>
			</div>
		</div>

	<%
		}
	%>
			
</div>		


</div>
<br><br>
	
	
</body>
</html>