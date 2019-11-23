<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://csdn.hbsi/pageTag" prefix="q"%>
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
/* 分页标签样式 */
.pagination {
	text-align: center;
	padding: 5px;
	margin: 0 auto;
}

.pagination a,.pagination a:link,.pagination a:visited {
	padding: 2px 5px 2px 5px;
	margin: 2px;
	border: 1px solid #aaaadd;
	text-decoration: none;
	color: #006699;
}

.pagination a:hover,.pagination a:active {
	border: 1px solid #ff0000;
	color: #000;
	text-decoration: none;
}

.pagination span.current {
	padding: 2px 5px 2px 5px;
	margin: 2px;
	border: 1px solid #ff0000;
	font-weight: bold;
	background-color: #ff0000;
	color: #FFF;
}

.pagination span.disabled {
	padding: 2px 5px 2px 5px;
	margin: 2px;
	border: 1px solid #eee;
	color: #ddd;
}
</style>
		<!-- IE6、7、8支持HTML5标签 -->
		<!--[if lte IE 8]><script src="js/html5.js"></script><![endif]-->
		<!-- IE6、7、8支持CSS3特效 -->
		<!--[if lte IE 8]><script src="js/PIE.js"></script><![endif]-->
		<!--[if lt IE 9]><script type="text/javascript" src="selectivizr-min.js"></script><![endif]-->
		<title>网上书店系统</title>
	</head>
	<body>
		<!-- 头部 -->
		<header>
		<nav>
		<div id="topNav">
			<ul>
				<li class="welcome">
					您好${user.uname}，欢迎光临网上书店系统！请
				</li>
				<!--  
				<li>
					<a href="<%=path%>/login.jsp">[登陆]</a>
				</li>
				<li>
				    <a href="<%=path%>/register.jsp">[免费注册]</a>
				</li>
				-->
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
			</ul>
		</div>
		</nav>
		</header>
		<div id="logo"></div>
		<div id="main">
			<div id="bookType">
				<div class="bookTypeTitle">
					<span>显卡类别</span>
				</div>
				<div class="bookTypeCon">
					<span>本系统所有显卡列表</span>
				</div>
			</div>
			<div id="buy">
				<!-- 导航 -->
				<div id="buyNav">
					<ul>
                    <c:forEach var="pt" items="${ptlist}">
						<li>
					   <a href="<%=path%>/ProductTypeServlet?ptid=${pt.cid}">${pt.cName}</a> 
						</li>
                    </c:forEach>
					</ul>
				</div>
				<!-- 详细 信息-->
				<div class="detailed">
					<ul>
						<c:forEach var="pi" items="${datas}">
							<li class="row">
								<div class="imgDri">
									<img src="<%=path%>/img/${pi.img}" class="imgPro">
								</div>
								<div class="bookProperty">
									<ul>
										<li>
											<span class="bookLabel">名称：</span>${pi.pname}
										</li>
										<li>
											<span class="bookLabel">价格：</span>${pi.price}
										</li>
										<li >
											<span class="bookLabel">数量：</span>${pi.pnumber }
										</li>
										<li >
											<span class="bookLabel">供应商：</span>${pi.suppliers }
										</li>
										<li >
											<span class="bookLabel">描述：</span><div class="overFlow">${pi.descw }</div>
										</li>
									</ul>
								</div>
								<div class="joinShopCar">
									<a href="<%=path%>/addCart?pname=${pi.pname}"><img
											src="<%=path%>/img/buy.gif">
									</a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div id="page">
				<q:pager pageNo="${pageNo}" pageSize="${pageSize}"
					recordCount="${recordCount}" url="/shopping/servlet/PageServlet" />
			</div>
		</div>
		<!-- 脚部 -->
		<footer>
		<div class="copyright">
			Adams丶 © 2013. All Rights Reserved.
		</div>
		</footer>
	</body>
</html>
