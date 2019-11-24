<%@ page language="java" import="java.util.*,com.scmpi.book.entity.Cart" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

.contant{
	background-color:#0000;
	height:400px;
	width:400px;
	margin-left:40px;
	margin-right:40px;

}
</style>
		<!-- IE6、7、8支持HTML5标签 -->
		<!--[if lte IE 8]><script src="js/html5.js"></script><![endif]-->
		<!-- IE6、7、8支持CSS3特效 -->
		<!--[if lte IE 8]><script src="js/PIE.js"></script><![endif]-->
		<!--[if lt IE 9]><script type="text/javascript" src="selectivizr-min.js"></script><![endif]-->

<script type="text/javascript">

	function user(){
		var ca = document.getElementById("userID");
		ca.action = "/shopping/servlet/UserAdminServlet";
		ca.submit();
	
	}
	function product(){
		var ca = document.getElementById("productID");
		ca.action = "/shopping/servlet/ProductAdminServlet";
		ca.submit();
	
	}
	function order(){
		var ca = document.getElementById("orderID");
		ca.action = "/shopping/servlet/OrderAdminServlet";
		ca.submit();
	
	}

</script>
	</head>
	<body >
		<!-- 头部 -->
		<header>
		<nav>
		<div id="topNav">
			<ul>
				<li class="welcome">
					您好${user.uname}，欢迎登录后台系统！
				</li>
				
				<li>
					<a href="<%=path%>/admin/admin.jsp">[返回主页]</a>
				</li>
			</ul>
		</div>
		</nav>
		</header>
		
		<div  style="overfloat:hidden;height:1200px;width:90%;margin:0 auto; margin-top:80px;">
			<div style="width:15%;height:1000px;float:left;background-color:#ccc">
				<!-- 左边菜单 -->
				<ul style="width:100%;height:100%;">
					<li style="list-style-type:none;border:1px #000 solid;height:30px;width:90%;margin:0 auto;margin-left:10px;mrigin-right:10px;margin-top:10px;">
					<form id="userID" method="post" action="">
						<a href="javascript:user();" style="width:100%;height:100%;border:0px;line-height:30px; text-align:center;display:block;background-color:#272822">用户管理</a>
					</form>
					</li>
					<li style="list-style-type:none;border:1px #000 solid;height:30px;width:90%;margin:0 auto;margin-left:10px;mrigin-right:10px;margin-top:10px;">
						<form id="productID" method="get" action="">
						<a href="javascript:product();" style="width:100%;height:100%;border:0px;line-height:30px; text-align:center;display:block;background-color:#272822">商品管理</a>
					</form>
					</li>
					<li style="list-style-type:none;border:1px #000 solid;height:30px;width:90%;margin:0 auto;margin-left:10px;mrigin-right:10px;margin-top:10px;">
						<form id="orderID" method="get" action="">
						<a href="javascript:order();" style="width:100%;height:100%;border:0px;line-height:30px; text-align:center;display:block;background-color:#272822" >订单管理</a>
						</form>
					</li>
					
				</ul>
				
			</div>
			<div style="float:right;width:85%;background-color:#fff;height:1000px;">
				<!-- 右边详情页 -->
				
				<h2>欢迎登录显卡商城后台！</h2>
				
				
			</div>
		
		
		</div>

		
		
	</body>
</html>