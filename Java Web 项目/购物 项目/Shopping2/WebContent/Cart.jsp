<%@page import="java.util.*" import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dao.Cart"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDao" %>
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
	function BuyShopping() {
		if (!confirm("确认要购买?"))
			window.event.returnValue = false;
	}
</script>


<title>购物车列表</title>
</head>

<body>
	<h1>我的购物车</h1>
	<a href="Show_All_information.jsp">商品列表</a>
	<a href="Buy.jsp">购买记录</a>

	<hr>
	<div id="shopping">
		<table>
			<tr>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>购买数量</th>
				<th>商品总价</th>				
				<th>操作</th>
			</tr>


			<%
			ItemsDao I = new ItemsDao();
			Cart cart = new Cart();
			
			ArrayList<Cart> list = I.Select_From_Cart();
				if (list != null && list.size() >0 ) {
					for(int i=0; i<list.size(); i++)
					{
						Cart c = list.get(i);
						Items item = I.getItems_information(c.getCart_id());
					
			%>

			<tr name="products" id="product_id_1">

				<td class="thumb"><img src="images/<%=item.getPicture()%>" />
					<a href="show_details.jsp?id=<%=item.getId()%>"><%=item.getName()%></a>
				</td>

				<td class="number"><%=item.getPrice()%></td>
				
				<td class="number"><%=c.getCart_number()%></td>
				
				<td class="price" id="price_id_1"><span> <%=item.getPrice() * c.getCart_number()%>
				</span></td>

				<td class="delete"><a
					href="Servlet/BuyServlet?action=BuyShoppingFromCart&Buy_id=<%=item.getId()%>&name=<%=item.getName()%>&city=<%=item.getCity()%>&picture=<%=item.getPicture()%>&price=<%=item.getPrice()%>&Buy_number=<%=c.getCart_number()%>"
					onclick="BuyShopping()">购买</a></td>
					
				<td class="delete"><a
					href="Servlet/CartServlet?action=DeleteCartRecord&id=<%=c.getCart_id()%>&DeleteNumber=<%=c.getCart_number() %>"
					onclick="delete_Cart()">删除</a></td>
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