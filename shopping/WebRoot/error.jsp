<%@ page language="java" import="java.util.*,com.scmpi.book.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ErrorMsg em =(ErrorMsg)session.getAttribute("ErrorMsg");	//获取错误信息
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    出现错误<br>
    
    <%if (em != null){ %>
    
    <h2>错误信息:<%=em.getMsg() %></h2>
    <p>根据错误，您可以<a href="<%=path %><%=em.getFoxurl() %>">点击此处</a>进行操作！</p>
    
    
    <%} %>
  </body>
</html>
