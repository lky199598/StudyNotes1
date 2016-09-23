<%@page import="java.sql.ResultSet"%>
<%@page import="com.po.*"%>
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
		<br>
		<br>
		<br>
		<br>

		<%
			String id = request.getParameter("ID");
			jdbc j = new jdbc();
			Student stu = new Student(Integer.parseInt(id));
			j.delete(stu);

			ResultSet res = j.select_from_ID(stu);
			if (!res.next()) {
		%>
		<h3><%=id%>学生信息已成功删除
		</h3>
		<form action="right.jsp" method="post">
			<input type="submit" value="返回">
		</form>

		<%
			res.close();j.close();
			} else {
				
		%>
		<h3><%= id%>学生信息删除失败</h3>
		<form action="deleteStudent.jsp" method="post">
			<input type="submit" value="返回">
		</form>
		<%
			}
		%>

	</center>

</body>
</html>