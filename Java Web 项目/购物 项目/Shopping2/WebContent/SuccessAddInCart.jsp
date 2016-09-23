<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<center>
		<img src="images/add_cart_success.jpg" />
		<hr>
		您成功将<%=request.getParameter("number")%>件编号为<%=request.getParameter("id")%>的商品加入购物车

	<%-- 	<script type="text/javascript">
             //直接跳转
           window.location.href='show_details.jsp?id=<%=request.getParameter("id")%>';
         //定时跳转
           setTimeout("javascript:location.href='show_details.jsp?id=<%=request.getParameter("id")%>'",
					3000);
		</script>
 --%>
	</center>
</body>
</html>


