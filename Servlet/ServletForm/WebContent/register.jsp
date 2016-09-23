<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>

<script type="text/javascript" src="js/Calendar3.js"></script>

<style type="text/css">
.word {
	width: 20%
}

.text {
	width: 80%
}
</style>


</head>

<body>
<br>
	<h1 align="center">用户注册</h1>
	<br>
	<center>
		<form action="Servlet/GetUser" name="register" method="post">

			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" /></td>
				</tr>

				<tr>
					<td>密码:</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<tr>
					<td>邮箱:</td>
					<td><input type="text" name="email"></td>
				</tr>

				<tr>
					<td>性别:</td>
					<td><input type="radio" name="gender" value="Male"
						checked="checked">男&nbsp;<input type="radio" name="gender"
						value="Female">女</td>
				</tr>


				<tr>
					<td>出生日期:</td>
					<td><input type="text" name="birthday" id="control_date"
						size="10" maxlength="10" onclick="new Calendar().show(this);"
						readonly="readonly" /></td>
				</tr>

				<tr>
					<td>爱好:</td>
					<td><input type="checkbox" name="favorite" value="阅读">阅读
						&nbsp; <input type="checkbox" name="favorite" value="音乐">音乐&nbsp;
						<input type="checkbox" name="favorite" value="电影">电影&nbsp;
						<input type="checkbox" name="favorite" value="运动">运动&nbsp;
					</td>
				</tr>

				<tr>
					<td class="word">自我介绍:</td>
					<td class="text"><textarea rows="=20" cols="50"
							name="introduce"></textarea></td>
				</tr>
				
				<tr>
					<td>接受协议:</td>
					<td><input type="checkbox" name="isAccept" value="true" checked="checked">是否接受条款</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="注册">&nbsp;<input
						type="reset" value="取消" /></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>