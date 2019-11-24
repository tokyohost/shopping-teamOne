<%@ page language="java" import="java.util.*,com.scmpi.book.entity.Cart,com.scmpi.book.entity.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Order> Orderlist =(List<Order>)session.getAttribute("Orderlist");
%>
<!DOCTYPE>
<html lang="en">
	<head>
		<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
	   <meta http-equiv="cache-control" content="no-cache">
		<link rel="stylesheet" href="<%=path%>/css/cssreset-min.css">
		<link rel="stylesheet" href="<%=path%>/css/index.css">
		<link rel="stylesheet" href="<%=path%>/css/global.css">
		<style type="text/css">
/* CSS Document */
body {
	font: normal 12px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#showdata{
    position:absolute;
	font: bold 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	margin-top: 180px;
	margin-bottom:200px;
	margin-left: 600px;
	color: #FF0000;
}

/*---------for IE 5.x bug*/
html>body td {
	font-size: 11px;
}
body {
	font: normal 12px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 700px;
	padding: 0;
	margin: 0;
}

#tabledata {
	margin: 0px auto;
	width: 900px;
	margin-top: 30px;
}

#showdata {
	font: bold 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	margin-top: 30px;
	margin-left: 100px;
	color: #FF0000;
}

caption {
	padding: 0 0 5px 0;
	width: 700px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(images/bullet1.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(images/bullet2.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}

/*---------for IE 5.x bug*/
html>body td {
	font-size: 11px;
}

</style>
		<!-- IE6、7、8支持HTML5标签 -->
		<!--[if lte IE 8]><script src="js/html5.js"></script><![endif]-->
		<!-- IE6、7、8支持CSS3特效 -->
		<!--[if lte IE 8]><script src="js/PIE.js"></script><![endif]-->
		<!--[if lt IE 9]><script type="text/javascript" src="selectivizr-min.js"></script><![endif]-->
<script>

<% for (Order o:Orderlist){%>

<%if(o.getOrder_status().equals("已签收")){ %>
									function Receipt<%=o.getUuid() %>() {
									consle.log("MDZZ");
									}
								<%}else{ %>
									function Receipt<%=o.getUuid() %>() {
											var ca = document.getElementById("from<%=o.getUuid() %>");
											ca.action = "/shopping/ReceiptServlet";
											ca.submit();
									}
								<%} %>

	
<%}%>
</script>
	</head>
	<body >
		<!-- 头部 -->
		<header>
		<nav>
		<div id="topNav">
			<ul>
				<li class="welcome">
					您好${user.uname}，欢迎光临网上显卡系统！
				</li>
				<li>
					<a href="<%=path%>/cart.jsp">[查购物车]</a>
				</li>
				<li>
					<a href="<%=path%>/order.jsp">[去购物车结算]</a>
				</li>
				<li>
					<a href="<%=path%>/OrderShowServlet">[查询订单]</a>
				</li>
				<li>
					<a href="#">[积分:${user.integral }]</a>
				</li>
				<li>
					<a href="#">[余额:${user.balance }]</a>
				</li>
				<li>
					<a href="<%=path%>/BackIndexServlet">[返回主页]</a>
				</li>
			</ul>
		</div>
		</nav>
		</header>
		<div id="tabledata">
					<table id="mytable" cellspacing="0"
						summary="The technical specifications of the Apple PowerMac G5 series">
						<tr>
						<th scope="col" abbr="Dual 1.8">
								订单id
							</th>
							<th scope="col" abbr="Dual 1.8">
								订单内容
							</th>
							<th scope="col" abbr="Dual 2">
								总计
							</th>
							<th scope="col" abbr="Dual 2.5">
								订单状态
							</th>
							<th scope="col" abbr="Dual 2.5">
								下单时间
							</th>
							<th scope="col" abbr="Dual 2.5">
								操作
							</th>
						</tr>
						<%for(Order item:Orderlist){ %>
						<form id="from<%=item.getUuid() %>" method="post" action="" >
							<tr>
								<td>
									<%=item.getOrder_id() %>
								</td>
								<td>
								<%for(OrderItem oi:item.getItems()){ %>
									<%=oi.getP().getPname() %>
									<span>x </span> <%=oi.getOrder_num() %>
									<br>
								
								<%} %>
								</td>
								<td>
									<%=item.getTotal_amount() %>
								</td>
								<td>
									<%=item.getOrder_status() %>
								</td>
								<td>  
									<%=item.getOrder_date() %>
								</td>
								<td>
								<input  type="hidden" name="uuid" value="<%= item.getUuid() %>">
								<%if(item.getOrder_status().equals("已签收")){ %>
									<input  type="button" disabled="disabled" value="确认收货 " onclick="Receipt<%= item.getUuid()%>()">
								<%}else{ %>
									<input  type="button"  value="确认收货 " onclick="Receipt<%= item.getUuid()%>()">
								<%} %>
								</td>
							</tr>
							</form>
						<%} %>
					</table>
			<br>
			<br>
			<br>
			<br>
		</div>
			
		</div>
		
	</body>
</html>