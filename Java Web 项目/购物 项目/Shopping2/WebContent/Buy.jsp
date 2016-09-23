<%@page import="java.util.*" import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="dao.Cart"%>
<%@ page import="entity.BuyShopping"%>
<%@ page import="dao.ItemsDao"%>
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
	function DeleteBuyRecord() {
		if (!confirm("确认要删除该条记录?"))
			window.event.returnValue = false;
	}
</script>


<title>购买记录</title>
</head>

<body>
	<h1>我的购买记录</h1>
	<a href="Show_All_information.jsp">商品列表</a>
	<a href="Cart.jsp">我的购物车</a>
	<hr>
<h1 align="center">商品购买记录</h1>
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
              ItemsDao ID = new ItemsDao();
			 BuyShopping BS = new BuyShopping();
			
				ArrayList<BuyShopping> list = ID.Select_BuyShopping();
				if (list != null && list.size() > 0) {
					for (int i = list.size()-1; i >= 0; i--) {
						BuyShopping bs = list.get(i);
					
			%>

			<tr name="products" id="product_id_1">

				<td class="thumb"><img src="images/<%=bs.getPicture()%>" />
					<a href="show_details.jsp?id=<%=bs.getBuy_id()%>"><%=bs.getName()%></a>
				</td>

				<td class="number"><%=bs.getPrice()%></td>
				
				<td class="number"><%=bs.getNumber()%></td>
				<td class="price" id="price_id_1"><span> <%=bs.getPrice() * bs.getNumber()%>
				</span></td>

                 <!-- 商品数量会变化 -->
				<td class="delete"><a
					href="Servlet/BuyServlet?action=DeleteBuyRecord&Buy_id=<%=bs.getBuy_id()%>&DeleteNumber=<%=bs.getNumber()%>"
					onclick="DeleteBuyRecord()">删除记录</a></td>


			</tr>
			<%
				}
			%>

		</table>

		<div class="total">
			<span id="total">总计：<%=BS.TotalPrice()%></span>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>