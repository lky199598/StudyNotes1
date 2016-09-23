<%@page import="java.sql.ResultSet"%>
<%@page import="com.po.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除学生信息</title>
</head>
<body>
<center>
<br><br>
<h2>选择要删除的学生信息</h2>
<br><br>
<form action="deleteStudentCheck.jsp" method="post">
学生学号<select name="ID">
<%
Student stu = new Student();
jdbc j = new jdbc();
ResultSet res = j.select_All_Information(stu);
while(res.next())
{
%>
<option value="<%=res.getString("id") %>"><%=res.getString("id") %></option>
<%
}
%>
</select>
<br><br>
<input type="submit" value="确定">&nbsp;
<input type="reset" value="取消" onclick="javascript:history.go(-1)">
</form>

</center>
</body>
</html>