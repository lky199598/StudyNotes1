<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.tiantian.model.*" import="java.util.*"
	import="com.opensymphony.xwork2.ActionContext"
	import="com.google.gson.*"
	isELIgnored="false"%>  
<html>
<head>
<meta charset="gb-2312" />
<title>天天短租网-让我遇见你</title>
<link href="css/user_view_top.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js">
 $(function() {
		/* For zebra striping */
        $("table tr:nth-child(odd)").addClass("odd-row");
		/* For cell text alignment */
		$("table td:first-child, table th:first-child").addClass("first");
		/* For removing the last border */
		$("table td:last-child, table th:last-child").addClass("last");
});
</script>
<style type="text/css">

	div,span, object, iframe,
	h1, h2, h3, h4, h5, h6, p, blockquote, pre,
	abbr, address, cite, code,
	del, dfn, em, img, ins, kbd, q, samp,
	small, strong, sub, sup, var,
	b, i,
	dl, dt, dd, ol, ul, li,
	fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td {
		margin:0;
		padding:0;
		border:0;
		outline:0;
		font-size:100%;
		vertical-align:baseline;
		background:transparent;
	}
	.a1 {color:#666;}
	
	#content {width:65%; max-width:1200px; margin:6% auto 0;}
	
	/*
	Pretty Table Styling
	CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
	*/
	
	table {
		overflow:hidden;
		border:1px solid #d3d3d3;
		background:#fefefe;
		width:85%;
		margin:5% auto 0;
		-moz-border-radius:5px; /* FF1+ */
		-webkit-border-radius:5px; /* Saf3-4 */
		border-radius:5px;
		-moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
		-webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
	}
	
	th, td {padding:18px 28px 18px; text-align:center; }
	
	th {padding-top:22px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}
	
	td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
	
	tr.odd-row td {background:#f6f6f6;}
	
	td.first, th.first {text-align:left}
	
	td.last {border-right:none;}
	
	/*
	Background gradients are completely unnecessary but a neat effect.
	*/
	
	td {
		background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
	}
	
	tr.odd-row td {
		background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1), to(#f6f6f6));
	}
	
	th {
		background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
		background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
	}

	
	tr:first-child th.first {
		-moz-border-radius-topleft:5px;
		-webkit-border-top-left-radius:5px; /* Saf3-4 */
	}
	
	tr:first-child th.last {
		-moz-border-radius-topright:5px;
		-webkit-border-top-right-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.first {
		-moz-border-radius-bottomleft:5px;
		-webkit-border-bottom-left-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.last {
		-moz-border-radius-bottomright:5px;
		-webkit-border-bottom-right-radius:5px; /* Saf3-4 */
	}
.center{text-align:center;}
.form1 {
    margin-left:auto;
    margin-right:auto;
    width: 800px;
    height: 100%;
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


.style2 {
	color: #666666;
	font-size: 14px;
	font-family: "方正兰亭超细黑简体"
}

.style5 {font-size: 36px; color: #3399CC;font-family: "方正兰亭超细黑简体" }
</style>
</head>

<style>
.center {
	text-align: center;
}

.form1 {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: 560px;
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
</style>

<body background="images/user_view_background.jpg" center>

	<%
		List<user> list = new LinkedList<user>();
		ActionContext actionContext = ActionContext.getContext();
		Map sess = actionContext.getSession();

		JsonParser parse = new JsonParser();
		JsonArray array = parse.parse(sess.get("user_list").toString())
				.getAsJsonArray();
		for (int i = 0; i < array.size(); i++) {
			JsonObject subObject = array.get(i).getAsJsonObject();
			list.add(new user(subObject.get("User_id" + i).toString(),
					subObject.get("User_name" + i) != null ? subObject.get(
							"User_name" + i).toString() : "null", "",
					subObject.get("User_telephone" + i) != null ? subObject
							.get("User_telephone" + i).toString() : "null",
					subObject.get("User_idcard" + i) != null ? subObject
							.get("User_idcard" + i).toString() : "null",
					subObject.get("User_sex" + i) != null ? subObject.get(
							"User_sex" + i).toString() : "null", subObject
							.get("User_birthday" + i) != null ? subObject
							.get("User_birthday" + i).toString() : "null"));
		}
		Iterator it = list.iterator();
		/* while (it.hasNext()) {
			out.println("----------------------------   <br>");
			user u = (user) it.next();
			out.println(u.getUser_id());
			out.println(u.getUser_name());
			out.println(u.getUser_sex());
			out.println(u.getUser_idacard());
			out.println(u.getUser_telephone());

			out.println("<br>");
		} */
		//out.println(session.getAttribute("user_list"));
	%>

	<h1>
		<a href="index.html"><img src="images/logo(1).png" border="0"></a>
	</h1>
	<div class="center">
<nav> 
<ul class="clear"> 
<li class="first"><a href="manage_user.action" class="style1 style2 style3">管理用户</a></li> 
<li><a href="manage_house.action" class="style2">验证房屋信息</a></li> 
<li><a href="#" class="style2">信息管理</a></li> 
<li><a href="#" class="style2">修改密码</a></li> 
<li class="last"><a href="#" class="style2">-3-</a></li> 
</ul> 
</nav> 
</div>
	
	<div class="form1">
	<div align="center"><span class="style5">尊敬的管理员，以下是用户信息</span>
  </div>
  <div >
    <table width="100%" cellspacing="0">
    <tr><th width="14%">用户ID</th>
      <th width="15%">姓名</th>
      <th width="14%">性别</th>
      <th width="22%">证件号</th>
      <th width="20%">手机号</th>
      <th width="15%">操作</th>
    </tr>
<%! String str; %>
    <%
   
    while (it.hasNext()) {   	
    	user u = (user) it.next();
    	str=u.getUser_id();
    	//System.out.println(str);
    	%>
    	<tr>
    
    		<td><%=u.getUser_id().replace("\"", "")%></td>
    		<td><%=u.getUser_name().replace("\"", "")%></td>
    		<td><%=u.getUser_sex().replace("\"", "")%></td>
    		<td><%=u.getUser_idcard().replace("\"", "")%></td>
    		<td><%=u.getUser_telephone().replace("\"", "")%></td>
    		<td>
    		  <form  id = "form" method="post" action="delete.action?id=<%=str.replace("\"", "")%>">
    		      <input type="submit" value="删除"/>
    		  </form>
    		</td></tr>
		<%						
    }
    	
    
    %>
     
    </table>

</div>
	</div>
		
</body>

</html>
