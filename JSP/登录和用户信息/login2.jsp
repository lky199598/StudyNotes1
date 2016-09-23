<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.po.User" %>
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
%>
<jsp:useBean id="user" class="com.po.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

用户名:<%=user.getUsername()%><br>
年龄:<%=user.getAge() %><br>
性别:<%=user.getSex() %><br>
地址:<%=user.getAddress() %>

</body>
</html>