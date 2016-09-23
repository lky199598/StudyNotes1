<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天短租网-让我遇见你</title>
</head>
<body>
	<h1>Hello, world!</h1>
	
	<br><br>
	
	${id }-----${password }
	
	<br><br>
	<%! %>
	<s:if test="id=='123'"><jsp:forward page="success.jsp"></jsp:forward></s:if>
	<s:else>id的值不是123</s:else>
</body>
</html>