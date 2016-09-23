<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tiantian.model.*" import="java.util.*"
	import="com.opensymphony.xwork2.ActionContext"
	import="com.google.gson.*"
	isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>天天短租网，让我遇见你</title>
</head>
<style>
 
#main{
 	margin-left:auto;
    margin-right:auto;
	width:80%;
	height:auto;
	}
	

#main_pic{
	width:533px;
	heigth:292px;
	float:left;
	}

.pic{
	padding:10px;
	border:1px solid #CCC;
	border-radius:5px;
	box-shadow:0 0 5px #CCC;
	width:512px;
	}

.pic img{
	display:block;
	width:511px;
	height:280px;
	}	

</style>




<body style="background-color:#d7e4e5">

<%
ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();

		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("select_house_list").toString())
				.getAsJsonArray();
%>
<div id="main">

<%   for(int i=0;i<array.size();i++){
	JsonObject subObject = array.get(i).getAsJsonObject();
	%>
	<div id="main_pic">

        <div class="pic">
            <a target="_blank" href="house_information.action?house_id=<%=subObject.get("House_id"+i).toString().replace("\"", "")%>&index=query"><img src="<%=subObject.get("Src"+i).toString().replace("\"", "")%>"/></a>
			
			<li>名称：<%=subObject.get("Name"+i).toString().replace("\"", "")%> </li>
			<li>地址：<%=subObject.get("Address"+i).toString().replace("\"", "")%> </li>
        </div>
    </div>
    
    <%} %>
    
</div>
</div>

</body>
</html>