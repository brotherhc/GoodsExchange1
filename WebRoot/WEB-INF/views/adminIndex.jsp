<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!doctype html>
<html lang="en">
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
    	管理员首页 <br>
		<a href="${ctx}/aaa/getAll"></a>
		<a href="${ctx}/aaa/getAll">查看全部用户</a>
		<a href="${ctx}/Goods/getAll">物品管理</a>
		<a href="${ctx}/aaa/index">新增数据</a>
		<a href="${ctx}/Inform/getAll">查看被举报用户</a>
		<a href="${ctx}/Requirements/getAll">需求查看</a>
  		<a href="${ctx}/attribute/select">关键字</a>

  </body>
</html>
