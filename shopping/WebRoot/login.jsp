<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
		
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
	margin-left: 100px;
	color: #FF0000;
}

#showdata3 {
    position:absolute;
	font: bold 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	margin-top: 180px;
	margin-left: 100px;
	color: #FF0000;
}

#logintable {
	margin-top: 230px;
	margin-left: 500px;
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
  <SCRIPT LANGUAGE="JavaScript">
	function onloadtest() {
		var h = document.body.scrollHeight + 38; //根据页面内容高度自动调整
		//var h = 500;
		var w = 700;//这里设置窗口的宽度
		window.resizeTo(w, h);
	}
</SCRIPT>

	</head>
	<body onload="onloadtest()">
		<!-- 头部 -->
		<header>
		<nav>
		<div id="topNav">
			<ul>
				<li class="welcome">
					您好${user.name}，欢迎光临网上书店系统！请
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

		<div id="showdata3">
			用户登录
		</div>
		<div id="logintable">
			<form action="<%=path%>/login" method="post">
				<table border="1">
					<tr>
						<td>
							用户名
						</td>
						<td>
							<input type="text" name="userName" />
						</td>
						<td>
							<font color="red">*
							</font>
						</td>
					</tr>
					<tr>
						<td>
							密码
						</td>
						<td>
							<input type="password" name="userPassword" />
						</td>
						<td>
							<font color="red">*
							</font>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" value="登陆" />
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
		</form>
	</body>
</html>