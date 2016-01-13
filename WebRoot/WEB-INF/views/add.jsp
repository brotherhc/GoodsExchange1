<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加数据</title>
    
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
			    <p>用户添加</p>
				<form action="${ctx}/aaa/userInfo" method="post">
					用户名：<input type="text" name="username"><br>
					密码：<input type="password" name="password"><br>
					<%--联系电话：<input type="text" name="Mobile">--%>
					<%--邮箱：<input type="text" name="Email">--%>
				<input type="submit" value="提交数据">
    		    </form>

				<h2>举报添加</h2>
				<%--goods added--%>
				<form action= "${ctx}/Inform/insert" method="post">
				<c:forEach var="list"  items="${goodsList}">
				举报用户ID：<input type="text" name="id" value="${userId.id}">
				物品ID：	<input type="text" name="goodsId"value=" ${list.id}"><br>
				被举报物品对应的用户id：<input type="text" name="informedUserId"value=" ${list.userId}"><br>
				举报内容：	<input type="text" name="content"><br>
				<input type="submit" value="提交数据">
				</c:forEach>
				</form>


				<p>需求添加</p>
				<form action= "${ctx}/Requirements/insert" method="post">
				用户ID：    <input type="text" name="userId">
					分类ID：    <input type="text" name="categoryId">
					描述：    <input type="text" name="description">
					属性：  <input type="text" name="attributes">
					需求图片：  <input type="text" name="pics">
					需求URL：  <input type="text" name="urls">
					状态：	  <input type="text" name="state">
					更新时间：<input type="text" name="updatedAt">
					创建时间：<input type="text" name="createdAt">
				<input type="submit" value="提交数据">
			</form>
					<c:forEach var="list"  items="${goodsList}">
			   <h2>物品添加</h2>
				<form action="${ctx}/Goods/insert" method="post">
								 <input type="hidden" name="userId" value="${list.userId}"><br>
					分类ID：    <input type="text" name="categoryId"><br>
					描述：    <input type="text" name="description"><br>
					属性：  <input type="text" name="attributes"><br>
					需求图片：  <input type="text" name="pics"><br>
					需求URL：  <input type="text" name="urls"><br>
					物品数量：<input type="text" name="numbers"><br>
					状态：	  <input type="text" name="state"><br>
					更新时间：<input type="text" name="updatedAt"><br>
					创建时间：<input type="text" name="createdAt"><br>
				<input type="submit" value="提交数据">
			</form>
						</c:forEach>
				<td>
					<h2>物品更新</h2>
					<c:forEach var="list"  items="${goodsList}">
					<form action= "${ctx}/Goods/update" method="post">
						用户ID：    <input type="text" name="userId" value="${list.userId}"><br>
						分类ID：    <input type="text" name="categoryId" value="${list.categoryId}"><br>
						描述：    <input type="text" name="description" value="${list.description}"><br>
						属性：  <input type="text" name="attributes" value="${list.attributes}"><br>
						需求图片：  <input type="text" name="pics" value="${list.pics}"><br>
						需求URL：  <input type="text" name="urls" value="${list.urls}"><br>
						物品数量：<input type="text" name="numbers" value="${list.numbers}"><br>
						状态：	  <input type="text" name="state" value="${list.state}"><br>
						默认状态：	  <input type="text" name="status" value="${list.status}"><br>
						更新时间：<input type="text" name="updatedAt" value="${list.updatedAt}"><br>
						创建时间：<input type="text" name="createdAt" value="${list.createdAt}"><br>
						<input type="hidden" name="id" value="${goods.id }">
						<input type="submit" value="提交数据">
					</form>
				</td>
				</c:forEach>


  </body>
</html>
