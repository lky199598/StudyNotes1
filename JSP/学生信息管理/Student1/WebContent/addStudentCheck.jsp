<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.po.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生信息</title>
</head>
<body>
	<center>
		<br>
		<br>

		<%
			request.setCharacterEncoding("utf-8");
		%>

		<jsp:useBean id="stu" class="com.po.Student" scope="session"></jsp:useBean>
		<jsp:setProperty property="*" name="stu" />
		<%
	    jdbc j = new jdbc();
		j.insert(stu); 
		ResultSet res=j.select_from_ID(stu);
		if(res.next())
		{
		%>
		<h3>学生信息已添加成功</h3>
		<br>
		
		<table>
		<tr>
			<td>学号:&nbsp;<%=res.getString("id")%></td>
		</tr>

		<tr>
			<td>姓名:&nbsp;<%=res.getString("name")%></td>
			</tr>

		<tr>
			<td>性别:&nbsp;<%=res.getString("sex")%></td>
			</tr>
			
		<tr>
			<td>年龄:&nbsp;<%=res.getString("age")%></td>
			</tr>
			
		<tr>
			<td>体重:&nbsp;<%=res.getString("weight")%></td>
		</tr>
		</table>
		
		<br>
		<form action="right.jsp" method="get">
			<input type="submit" value="返回" />
		</form>
		<%
			res.close();j.close();
			}
			else
		{
		%>
		<h3>学生信息添加失败</h3>
		<form action="addStudent.jsp" method="get">
			<input type="submit" value="返回" />
		</form>
		<%
			}
		%>
	</center>
</body>
</html>