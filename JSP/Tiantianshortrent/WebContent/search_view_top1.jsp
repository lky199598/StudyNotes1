<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天短租网-让我遇见你</title>
<script src="js/jquery-1.7.1.min.js"></script>
<link href="css/search_view.css" rel="stylesheet" type="text/css" />
</head>
<style>
.hr0{ height:1px;border:none;border-top:1px dashed #1E90FF;}
.style1 {
	color: #6699FF;
	font-family: "方正兰亭超细黑简体";
	font-size: 18px;
	font-weight: bold;
}
</style>



<body style="background-color:#d7e4e5">

<br>
<div class="container1">
   <div class="search_container">
   <div>
   <form action="select_house.action" method="post">
  	<input  placeholder="请输入城市名" type="text" name="location_search" class="location"/>
	<input placeholder="可输入房间名或房东名" type="text" name="detail_search" class="detail_search"/>
	<input placeholder="入住日期" type="text" name="ruzu_date" class="indate" />
	<input placeholder="退房日期" type="text" name="tuifang_date" class="outdate" />
	<input name="submit_search" class="btn" type="submit" value="搜索" formtarget="mainFrame" />
	
   </div>
   </div>
   <br>
    
    <hr class="hr0" />

	<div id="main">
	<div class="style1" id="left">价格：</div>
	<div id="mid"><input name="lowest" type="text" class="lowest">&nbsp;&nbsp;---</div>
	<div id="right"><input name="highest" class="highest" type="text"></div>	
	</div>
	
	
   <hr class="hr0" />
	<div class="style1" id="left">面积：</div>
	<div id="mid"><input name="lowestarea" type="text" class="lowest">&nbsp;&nbsp;--- </div>
	<div id="right"><input name="highestarea" class="highest" type="text"></div>

</form>
   <hr class="hr0" />
   
          		
</div>

</body>

</html>