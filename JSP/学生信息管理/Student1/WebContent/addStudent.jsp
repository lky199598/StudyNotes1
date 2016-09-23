<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生信息</title>
</head>
<body>
<center>
<br><br><br>
<h3>添加学生信息</h3>
<form action="addStudentCheck.jsp" method="post">
<table>
<tr>
<td>学号</td>
<td><input type="text" name="id" ></td>
</tr>

<tr>
<td>姓名</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>性别</td>
<td><input type="text" name="sex"></td>
<tr>

<tr>
<td>年龄</td>
<td><input type="text" name="age"></td>
</tr>

<tr>
<td>体重</td>
<td><input type="text" name="weight"></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" name="submit" value="提交">&nbsp;&nbsp;<input type="reset" name="reset" value="取消">
</td>
</tr>
</table>
</form>

</center>
</body>
</html>