<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
	function ReloadCode() {
		var time = new Date().getTime();
		document.getElementById("ImageCode").src = "Servlet/ImageServlet?d="+time;
	}
</script>

</head>
<body>


	<form action="Servlet/Login_Result_Servlet" method="post">
		验证码: <input type="text" name="CheckCode"> <img id="ImageCode"
			alt="验证码" src="Servlet/ImageServlet"> <a
			href="javascript:ReloadCode();">看不清楚</a> <br> <input
			type="submit" value="提交">
	</form>
</body>
</html>