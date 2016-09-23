
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>系统登录</h1>
<%
//request.setCharacterEncoding("utf-8");

String username="";
String password="";
Cookie[] coo = request.getCookies();
if(coo != null && coo.length>0)
{
	for(Cookie c : coo)
	{
		if(c.getName().equals("username"))
			username = URLDecoder.decode(c.getValue(), "utf-8");
		else
			if(c.getName().equals("password"))
				password = URLDecoder.decode(c.getValue(), "utf-8");				
	}
}
%>

<form name="loginForm" action="dologin.jsp" method="post">

<table>

<tr>
<td>用户名:</td>
<td><input type="text" name = "username" value="<%=username%>"/></td>
</tr>

<tr>
<td>密码: </td>
<td><input type="password" name="password" value="<%=password%>"/></td>
</tr>

<tr>
<td colspan="2"><input type="checkbox" name="IsUseCookie" checked="checked">十天内记住我的登录状态</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="登录"/><input type="reset" value = "取消"/></td>
</tr>

</table>
</form>
</body>
</html>