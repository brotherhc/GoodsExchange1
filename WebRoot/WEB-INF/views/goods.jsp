<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2015/7/30 0030
  Time: 上午 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    物品管理
    <table border="1">
        <tr>
            <td>用户id</td>
            <td>分类id</td>
            <td>描述</td>
            <td>属性</td>
            <td>需求图片</td>
            <td>需求url</td>
            <td>物品数量</td>
            <td>物品状态</td>
            <td>更新时间</td>
        </tr>
        <c:forEach var="list"  items="${goodsList}">
            <tr>
                <td>${list.userId}</td>
                <td>${list.categoryId}</td>
                <td>${list.description}</td>
                <td>${list.attributes}</td>
                <td>${list.pics}</td>
                <td>${list.urls}</td>
                <td>${list.numbers}</td>
                <td>${list.state}</td>
                <%--<td>${list.updatedAt}</td>--%>
                <td>
                    <a href="${ctx}/GoodsExchange/Goods/select?id=${list.id}">更新</a>
                    <a href="${ctx}/GoodsExchange/Goods/delete?id=${list.id}">删除</a>
                    <a href="${ctx}/GoodsExchange/Goods/select?id=${list.id}">举报</a>
                    <a href="${ctx}/GoodsExchange/Goods/index?id=${list.id}">新增数据</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
