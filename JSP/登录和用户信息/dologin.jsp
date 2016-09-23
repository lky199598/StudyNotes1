
<%@ page language="java"  import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.po.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登陆成功!请补全信息</h1>
	<hr>	
	<%
		request.setCharacterEncoding("utf-8");
	%>
	  <% 
       //首先判断用户是否选择了记住登录状态
       String[] isUseCookies = request.getParameterValues("IsUseCookie");
       if(isUseCookies!=null&&isUseCookies.length>0)
       {
          //把用户名和密码保存在Cookie对象里面
          String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
          //使用URLEncoder解决无法在Cookie当中保存中文字符串问题
          String password = URLEncoder.encode(request.getParameter("password"), "utf-8");
          
          Cookie usernameCookie = new Cookie("username",username);
          Cookie passwordCookie = new Cookie("password",password);
          
          usernameCookie.setMaxAge(864000);
          passwordCookie.setMaxAge(864000);//设置最大生存期限为10天
          response.addCookie(usernameCookie);
          response.addCookie(passwordCookie);
       }
       else
       {
          Cookie[] cookies = request.getCookies();
          if(cookies!=null&&cookies.length>0)
          {
             for(Cookie c:cookies)
             {
                if(c.getName().equals("username")||c.getName().equals("password"))
                {
                    c.setMaxAge(0); //设置Cookie失效
                    response.addCookie(c); //重新保存。
                }
             }
          }
       }
    %>
		
	<jsp:useBean id="user" class="com.po.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="username" name="user" />
	
	<%
		String username = user.getUsername();
	%>

<form name="show_information" action="login2.jsp" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username" value="<%=username%>" /></td>
		</tr>

		<tr>
			<td>年龄:</td>
			<td><input type="text" name="age" value="" /></td>
		</tr>

		<tr>
			<td>性别:</td>
			<td><input type="text" name="sex" value="" /></td>
		</tr>

		<tr>
			<td>地址:</td>
			<td><input type="text" name="address" value="" /></td>
		</tr>
	
		<tr>
		<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>

	</table>
	</form>
</body>
</html>