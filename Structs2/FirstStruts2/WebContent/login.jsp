<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="loginSuccess.action" method="post">
用户名:<input type="text" name="username"/>

<s:fielderror name="username"></s:fielderror>
<br>

密码:<input type="password" name="password"/>
<br>
年龄:<input type="text" name="age"/>
<br>

<!-- 书籍1:<input type="text" name="bookList[0]"/>
<br>
书籍2:<input type="text" name="bookList[1]"/>
<br>
书籍1:<input type="text" name="userBookList[0].username"/>
<br>
书籍2:<input type="text" name="userBookList[1].username"/>
<br> -->
<input type="submit" value="提交"/>

</form>
</body>
</html>