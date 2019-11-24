<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.scmpi.book.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	Cart c = (Cart) session.getAttribute("cart");
	Collection<OrderItem> items = c.getMap().values();
	request.setAttribute("list1", items);
%>

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
	margin-left: 150px;
	color: #FF0000;
}
#showdata2
{
    font: bold 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	margin-top: 30px;
	margin-left:10px;
	color: #FF0000;
	margin-bottom:10px; 
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
	</head>
	<body>
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
		<div id="logo"></div>

		<div id="showdata">
			您购买商品如下:
		</div>

		<div id="tabledata">
			<table id="mytable" cellspacing="0"
				summary="The technical specifications of the Apple PowerMac G5 series">
				<tr>

					<th scope="col" abbr="Dual 1.8">
						商品名字
					</th>
					<th scope="col" abbr="Dual 2">
						单价
					</th>
					<th scope="col" abbr="Dual 2.5">
						数量
					</th>
					<th scope="col" abbr="Dual 2.5">
						价格
					</th>
				</tr>
				<c:forEach var="item" items="${list1}">
					<tr>

						<td>
							${item.p.pname}
						</td>
						<td>
							${item.p.price}
						</td>
						<td>
							${item.order_num}
						</td>
						<td>
							${item.order_subtotal}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						您的购物车中所有商品总金额：${cart.total_amount}<br>
						您拥有折扣权限：${(user.discount) /10 } 折<br>
						折扣后价格${cart.total_amount- (cart.total_amount*( (100 - user.discount) /100 ))}
					</td>
				</tr>
			</table>
             <div id="showdata2">
			  用户联系方式如下：
		     </div>
			<form action="<%=path%>/orderCart" method="post">
				<table border="1">
					<tr>
						<td>
							用户名
						</td>
						<td>
							${user.uname}
						</td>
					</tr>
					<tr>
						<td>
							地址
						</td>
						<td>
							<input type="text" name="uadd" value="${user.uaddress} " />
						</td>
					</tr>
					<tr>
						<td>
							手机号
						</td>
						<td>
							<input type="text" name="upost" value="${user.uphone} " />
						</td>
					</tr>
					<tr>
						<td>
							email
						</td>
						<td>
							<input type="text" name="umail" value="${user.uemail} " />
						</td>
					</tr>
					<tr>
					<!--  
						<td>
							电话号码
						</td>
						<td>
							<input type="text" name="uphone" value="${user.uphone} " />
						</td>
						-->
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="结帐" />
						</td>
					</tr>
				</table>
			</form>

		</div>
		<!-- 脚部 -->
		<footer>
		<div class="copyright">
			Adams丶 © 2013. All Rights Reserved.
		</div>
		</footer>
	</body>
</html>