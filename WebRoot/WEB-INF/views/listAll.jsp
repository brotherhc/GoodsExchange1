<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.fafukeji.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有数据</title>
    
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
    所有结果<br>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach var="list"  items="${userLists}">
    	<tr>
    		<td>${list.id}</td>
    		<td>${list.username}</td>
    		<td>${list.password}</td>
    		<td><a href="${ctx}/GoodsExchange/aaa/modify?id=${list.id}">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx}/GoodsExchange/aaa/del?id=${list.id}">删除</a><a href="#">举报</a></td>
    	</tr>
    	</c:forEach>

    </table>
  </body>
</html>