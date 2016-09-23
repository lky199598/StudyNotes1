<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>开发第一个Servlet</h1>
<hr>
<%-- <a href="Servlet/HelloServlet">get方式请求HelloServlet</a><br><br>

<a href="<%=request.getContextPath()%>/Servlet/HelloServlet">get方式请求HelloServlet</a><br><br>

<form action="Servlet/HelloServlet" method="get">
<input type="submit" value="get方式请求HelloServlet"/>
</form>
<br><br>

<form action="Servlet/HelloServlet" method="post">
<input type="submit" value="post方式请求HelloServlet"/>
</form> --%>

<form action="Servlet/requestScope" method="post">

<input type="submit" value="提交"/>

</form>

</body>
</html>