<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDao"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="css/main.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
	
	<script type="text/javascript">
	function  AddIntoCart(id) {
		var num = document.getElementById("number").value;
	    J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/Servlet/CartServlet?id='+id+'&number='+num+'&action=add', cover:true});
	}
	
	
	function add() {
		var num =parseInt( document.getElementById("number").value );
		if(num<10)
			{
			document.getElementById("number").value=++num;
			}
		
	}
	
	function sub() {
		var num =parseInt( document.getElementById("number").value );
		if(num > 1)
			{	
			document.getElementById("number").value=--num;
			}		
	}
	
	</script>
	
  <style type="text/css">
	   hr{
	     
	     border-color:FF7F00; 
	   }
	   
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	     
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	   div #cart
	   {
	     margin:0px auto;
	     text-align:right; 
	   }
	   span{
	     padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
	   }
	   a{
	      text-decoration: none; 
	   }
	</style>
	
  </head>
  
  <body>
    <h1>商品详情</h1>
    <a href="Show_All_information.jsp">商品列表</a>
    <hr>
    <center>
    
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <!-- 商品详情 -->
          
          <%
          ItemsDao itemsdao = new ItemsDao();
          Items item = itemsdao.getItems_information(Integer.parseInt(request.getParameter("id")));
          
          if(item != null )
          {
          %>
          
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="5"><img src="images/<%=item.getPicture()%>" width="200" height="160"/></td>
               </tr>
               
               <tr>
                 <td><B><%=item.getName() %></B></td> 
               </tr>
               
               <tr>
                 <td>产地：<%=item.getCity()%></td>
               </tr>
               
               <tr>
                 <td>价格：<%=item.getPrice() %>￥</td>
               </tr> 
               
              <tr>             
              <td>购买数量:
              <span id="sub" onclick="sub();">-</span>
               <input type="text" id="number" name="number" value="1" size="2"/>
               <span id="add" onclick="add();">+</span>
                </td>
                </tr>           
                               
             </table>
                                      
                <div id="cart">
                <img src="images/buy.png">
                <a href="javascript:AddIntoCart(<%=item.getId() %>)"><img src="images/in_cart.png"></a>
                <a href="Servlet/CartServlet?action=show"><img src="images/view_cart.jpg"></a>            
                </div>
          </td>
          <% 
            }
          %>
          <br><br><br><br><br><br>
           
                                     
         <%         
         String record_id="";
         Cookie[] coo = request.getCookies();
         if(coo != null && coo.length > 0)
         {
        	for(Cookie c : coo)
        	{
        		if(c.getName().equals("Record_ID"))
        			record_id = c.getValue();        			
        	}
         }
         record_id+=request.getParameter("id")+",";
         
         String[] str = record_id.split(",");
         if(str!=null)
         {
         if(str.length >= 100)
        	 record_id=null;
         }
         
         Cookie cookie = new Cookie("Record_ID", record_id);
         response.addCookie(cookie);
         %>
                  
          <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b>您浏览过的商品</b><br>
             <!-- 循环开始 -->
             <% 
             ArrayList<Items> list = itemsdao.getFiveList(record_id);
             if(list != null && list.size()>0)
             {
                // System.out.println("itemlist.size="+list.size());
            	 for(Items items : list)
            	 {
             %>
             <div>
             <dl>
               <dt>
                 <a href="show_details.jsp?id=<%=items.getId()%>"><img src="images/<%=items.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=items.getName() %></dd> 
               <dd class="dd_city">产地:<%=items.getCity() %>&nbsp;&nbsp;价格:<%=items.getPrice() %> ￥ </dd> 
             </dl>
             </div>
             <% 
                   }
                }
             %>
             
             <br><br>
          
             <!-- 循环结束 -->
          </td>
        </tr>
      </table>
    </center>
  </body>
</html>
