<%@ page import="com.po.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.ResultSet"%>

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
		<%
			String strPage=request.getParameter("Page");
			int Page;
			if(strPage==null)
				Page=1;
			else
				Page=Integer.parseInt(strPage);
		%>

		<%
			Student stu = new Student();
			jdbc j = new jdbc();
			ResultSet res = j.select_All_Information(stu);
			res.last();
		%>
		
		<%
			int RowCount= res.getRow();//总共的记录
				int PageSize=5;//每页的个数
				int PageCount;//页数
				if(RowCount%PageSize==0)
			PageCount=RowCount/PageSize;
				else
			PageCount=RowCount/PageSize+1;
		%>

		你要查询的学生有 <font size="5" color="black"> <%=RowCount%>
		</font>人 <br>
		<br>
		<table border="2" width="1000">
			<tr>
				<th>记录条数</th>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>体重</th>
			</tr>
			<%
				res.absolute((Page-1)*PageSize+1);			
				int i=0;
				do
				 {
					i++;
			%>
			<tr align="center">
				<td><%=res.getRow()%></td>
				<td><%=res.getString("id")%></td>
				<td><%=res.getString("name")%></td>
				<td><%=res.getString("sex")%></td>
				<td><%=res.getString("age")%></td>
				<td><%=res.getString("weight")%></td>
			</tr>

			<%
				}while (res.next() && i<PageSize);
					res.close();
					j.close();
			%>
		</table>
	<br>
	第<%=Page%>页 共<%=PageCount%>页
	<br><br>
	<%
		if(Page>1)
		{
	%>
	<a href="lookStudent.jsp?Page=<%=Page-1%>">上一页</a>&nbsp;
	<%
		}
	%>
	<%
		i=1;
		while(i<Page)
		{
	%>
	<a href="lookStudent.jsp?Page=<%=i%>"><%=i%></a>&nbsp;
	<%
		i++;
		}
	%>

	<%=Page%>&nbsp;

	<%
		i=Page;
		while(i<PageCount)
		{
	%>
	<a href="lookStudent.jsp?Page=<%=++i%>"><%=i%></a>&nbsp;
	<%
		}
	%>

	<%
		if(Page<PageCount)
		{
	%>
	<a href="lookStudent.jsp?Page=<%=Page+1%>">下一页</a>
	<%
		}
	%>
</center>
</body>
</html>