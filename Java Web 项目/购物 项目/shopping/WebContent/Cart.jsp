<%@page import="java.util.*" import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dao.Cart"%>
<%@ page import="entity.Items"%>

<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'Cart.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link type="text/css" rel="stylesheet" href="css/style1.css" />

<script type="text/javascript">
	function delete_Cart() {
		if (!confirm("确认要删除?"))
			window.event.returnValue = false;
	}
</script>


<title>购物车列表</title>
</head>

<body>
	<h1>我的购物车</h1>
	<a href="Show_All_information.jsp">商品列表</a>
	<hr>
	<div id="shopping">
		<table>
			<tr>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>商品总价</th>
				<th>购买数量</th>
				<th>操作</th>
			</tr>


			<%
				if (request.getSession().getAttribute("cart") != null) {

					Cart cart = (Cart) request.getSession().getAttribute("cart");
					HashMap<Items, Integer> goods = cart.getGoods();

					for (Entry<Items, Integer> entry : goods.entrySet()) {
						Items item = entry.getKey();
			%>

			<tr name="products" id="product_id_1">

				<td class="thumb"><img src="images/<%=item.getPicture()%>" />
					<a href="show_details.jsp?id=<%=item.getId()%>"><%=item.getName()%></a>
				</td>

				<td class="number"><%=item.getPrice()%></td>
				<td class="price" id="price_id_1"><span> <%=item.getPrice() * entry.getValue()%>
				</span></td>

				<td class="number"><%=entry.getValue()%></td>

				<td class="delete"><a
					href="Servlet/CartServlet?action=delete&id=<%=item.getId()%>"
					onclick="deleteCart()">删除</a></td>
			</tr>
			<%
				}
			%>

		</table>

	<div class="total">
		<span id="total">总计：<%=cart.TotalPrice()%></span>
	</div>
	<%
		}
	%>
	</div>
</body>
</html>