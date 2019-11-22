<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

#showdata {
    position:absolute;
	font: bold 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	margin-top: 180px;
	margin-left: 100px;
	margin-bottom:200px;
	color: #FF0000;
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
	<body >
		<!-- 头部 -->
		<header>
		<nav>
		<div id="topNav">
			<ul>
				<li class="welcome">
					您好${user.name}，欢迎光临网上显卡系统！请
				</li>
				<li>
					<a href="<%=path%>/login.jsp">[登陆]</a>
				</li>
				<li>
					<a href="<%=path%>/register.jsp">[免费注册]</a>
				</li>
				<li>
					<a href="<%=path%>/cart.jsp">[查购购物车]</a>
				</li>
				<li>
					<a href="<%=path%>/order.jsp">[去购物车结算]</a>
				</li>
			</ul>
		</div>
		</nav>
		</header>
		<div id="logo"></div>

		<div id="showdata">
			注册成功！<a href="<%=path%>/login.jsp">[登录]</a>
		</div>
	    
		<!-- 脚部 -->
		<footer>
		<div class="copyright">
			Adams丶 © 2013. All Rights Reserved.
		</div>
		</footer>
		
	</body>
</html>