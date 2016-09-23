<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="辐射都很低哦撒<hr>" escapeXml="true"></c:out>
<br>

<c:out value="计算机的速度<hr>" escapeXml="false"></c:out>  


<br><br>
<jsp:useBean id="user" class="com.JavaBean.User" ></jsp:useBean>
<c:set target="${user}" property="name">说俗点</c:set>

<c:out value="User_name: ${user.name}"></c:out>

</body>
</html>