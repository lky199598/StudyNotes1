<%@page import="java.sql.ResultSet"%>
<%@page import="com.po.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<center>
<br><br>
<h2>更新学生信息</h2>
<br><br>

<%
Student stu = new Student(Integer.parseInt(request.getParameter("ID")));
jdbc j = new jdbc();
ResultSet res = j.select_from_ID(stu);
if(res.next())
{
%>

<h3>学号:<%=res.getString("id") %></h3>

<form action="Submit_update_Student.jsp" method="post">
<table>
<tr>
<td><input type="hidden" name="id" value="<%=res.getString("id") %>"> </td>
</tr>

<tr>
<td>姓名:</td>
<td><input type="text" name="name" value="<%=res.getString("name") %>"></td>
</tr>

<tr>
<td>性别:</td>
<td><input type="text" name="sex" value="<%=res.getString("sex")%>" ></td>
</tr>

<tr>
<td>年龄:</td>
<td><input type="text" name="age" value="<%=res.getString("age")%>" ></td>
</tr>

<tr>
<td>体重:</td>
<td><input type="text" name="weight" value="<%=res.getString("weight")%>" ></td>
</tr>

<%
}
%>
<tr>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="取消"/></td>
</tr>

</table>
</form>

</center>
</body>
</html>