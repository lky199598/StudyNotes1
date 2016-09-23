<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.po.jdbc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页浏览记录</title>
</head>
<body>
	<center>
		分页显示内容
		<hr>
		<br>
		<table border="1" width="600">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>city</th>
				<th>price</th>
				<th>number</th>
			</tr>

			<%
				int Page;
				String Strpage = request.getParameter("Page");
				if (Strpage == null)
					Page = 1;
				else
					Page = Integer.parseInt(Strpage);

				ResultSet res = jdbc.select();

				res.last();
				int RowCount = res.getRow();//返回当前记录指针指向的行号
				int PageSize = 3;
				int PageCount;//总页数

				if (RowCount % PageSize == 0)
					PageCount = RowCount / PageSize;
				else
					PageCount = RowCount / PageSize + 1;

				res.absolute((Page - 1) * PageSize + 1);//将记录指针移动到指定第row行

				int i = 0;
				do {
			%>
			<tr>
				<td align="center"><%=res.getString(1)%></td>
				<td align="center"><%=res.getString(2)%></td>
				<td align="center"><%=res.getString(3)%></td>
				<td align="center"><%=res.getString(4)%></td>
				<td align="center"><%=res.getString(5)%></td>
			</tr>
			<%
				i++;
				} while (i < PageSize && res.next());
			%>
		</table>

		<hr>
		<br> 第<%=Page%>页 共<%=PageCount%>页 <br>
		<%
			if (Page > 1) {
		%>
		<a href="pageBreak.jsp?Page=<%=Page - 1%>">上一页</a>&nbsp;
		<%
			}
		%>

		<%
			i = 1;
			while (i < Page)
			{
		%>
		<a href="pageBreak.jsp?Page=<%=i%>"><%=i%></a>&nbsp;
		<%
			i++;
			}
		%>

		<%=Page%>&nbsp;

		<%
			i = Page;
			while (i < PageCount) {
		%>
		<a href="pageBreak.jsp?Page=<%=++i%>"> <%=i%>
		</a>&nbsp;
		<%
			}
		%>

		<%
			if (Page < PageCount) {
		%>
		<a href="pageBreak.jsp?Page=<%=Page+1 %>">下一页</a>

		<%
}
res.close();
%>
	</center>
</body>
</html>