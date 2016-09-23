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

<h1>用户信息</h1>
<%
request.setCharacterEncoding("utf-8");
Cookie[] coo = request.getCookies();
String username="";
String password="";
if(coo!=null && coo.length > 0)
{
	for(Cookie c : coo)
	{
		if( c.getName().equals("username") )
	username = URLDecoder.decode(c.getValue(), "utf-8");
		else
			if(c.getName().equals("password"))
		 password = URLDecoder.decode(c.getValue(), "utf-8");		
	}
}
%>
用户名:<%=username%><br>
密码:<%=password %>


</body>
</html>