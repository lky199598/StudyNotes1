<%@ page language="java" import="java.util.*,com.Listener.User" pageEncoding="utf-8"%>
<%-- <%@ page language="java" import="com.Listener.User" %> --%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


request.setAttribute("requestName", "request值");
request.getSession().setAttribute("sessionName", "session值");
request.getSession().getServletContext().setAttribute("contextName", "context值");

request.getSession().setAttribute("CurrentSession", new User());

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    This is a Init JSP page. <br>
    
    <button
		onclick="location.href='<%=request.getContextPath()%>/Init.jsp';">Init</button>
	<button
		onclick="location.href='<%=request.getContextPath()%>/Destory.jsp'; ">Destory</button>
  </body>
</html>
