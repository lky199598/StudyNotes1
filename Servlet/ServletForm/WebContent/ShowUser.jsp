<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示用户信息</title>
</head>


<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="user" class="com.po.User" scope="session" />
	<br>
	<h1 align="center">用户信息</h1>
	<br>
	<center>
		<table border="1" width="1000" height="300"  align="center">
			<tr>
				<td>用户名:</td>
				<td><%=user.getUsername()%></td>
			</tr>

			<tr>
				<td>密码:</td>
				<td><%=user.getPassword()%></td>
			</tr>

			<tr>
				<td>邮箱:</td>
				<td><%=user.getEmail()%></td>
			</tr>


			<tr>
				<td>性别:</td>
				<td><%=user.getGender()%></td>
			</tr>

			<tr>
				<td>出生日期：</td>
				<td>
				 <%	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");%> 
				 <%=sdf.format(user.getBirthday())%>
				</td>
			</tr>

			<tr>
				<td>爱好:</td>
				<td>
					<%
						String favorites[] = user.getFavorite();
						for (String f : favorites) {
					%> <%=f%>&nbsp;&nbsp; <%
					}
						%>
				</td>
			</tr>

			<tr>
				<td>自我介绍:</td>
				<td><%=user.getIntroduce()%></td>
			</tr>

			<tr>
				<td>接受协议:</td>
				<td><%=user.isAccept()%></td>
			</tr> 
		</table>
		</form>
	</center>

</body>
</html>