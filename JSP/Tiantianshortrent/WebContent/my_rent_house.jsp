<%@ page language="java" contentType="text/html; charset=utf-8"
import="com.opensymphony.xwork2.ActionContext"
	import="com.google.gson.*"
	import="java.util.*"
	import="com.tiantian.dao.impl.*"
	pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
.box{
 	margin-left:auto;
    margin-right:auto;
	width:70%;
	height:1000px;
	border: #000 1px solid;
	margin-top: 50px;  margin-bottom: 10px; 
}
.box1{
	width:39%;
	height:300px;
	border: #000 1px solid;
	padding:5% 5% 5% 5%;
	float:left;
	}



 .style1 {
	font-size: 24px;
	font-family: "方正兰亭超细黑简体";
	color: #000000;
}

</style>

<title>天天短租网-让我遇见你</title>
</head>
<body>
<!-- <div class="box"> -->
<%
		ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();

		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("rent_house_list").toString())
				.getAsJsonArray();
		for (int i = 0; i < array.size(); i++) {
			JsonObject subObject = array.get(i).getAsJsonObject();
			%>
			
			<div class="box1" name=subObject.get("House_id" + i)>
			
			<a target="_blank" href="house_information.action?house_id=<%=subObject.get("House_id"+i).toString().replace("\"", "")%>&index=display"><img src="<%=subObject.get("Src" + i).toString().replace("\\\\", "/").replace("\"", "") %>" style="width:100%; height:80%"/></a>
			<br><br>
			<span class="style1">名称：</span>
			<%=
			(subObject.get("Name" + i) != null ? subObject.get(
					"Name" + i).toString() : "null").replace("\"", "")
			%>
			<br>
			<span class="style1">价格:</span>
			<%=
			(subObject.get("Price" + i) != null ? subObject
					.get("Price" + i).toString() : "null").replace("\"","")
			%>
			&nbsp;&nbsp;&nbsp;
			状态：
			<% jdbcDao dao=new jdbcDao("tiantian");
				String str=dao.current_house_state(Integer.parseInt(subObject.get("House_id" + i).toString().replace("\"", "")));
			
				if(Integer.parseInt(subObject.get("State" + i).toString().replace("\"", ""))==1){
					%>  已交易<%
				}
				else{
					%>  待房东确认<%
					%><br><form action="operate_state.action?House_id=<%=sess.get("current_id").toString()%>&index=quxiao" method="post"><input type="submit" value="取消订单"></form>
	
					<%
				}
			
			%> 
			
			 
			<br>
			</div>
			<%	
		}
			%>


	


<!-- <div class="box1">
			<img src="image/1.jpg" />
			<br>
			<span class="style1">名称:</span>&nbsp; 
			<br> <span class="style1">价格:</span>&nbsp;
			<br>
		</div>-->
		
<!-- </div>  -->
	
	
</body>
</html>