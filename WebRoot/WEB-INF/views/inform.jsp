<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 2015/7/28 0028
  Time: 下午 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
      举报系统
      所有结果<br>
      <c:forEach var="list"  items="${informList}">
      <table border="1">
          <tr>
              <td>举报用户id</td>
              <td></td>
              <td>物品id</td>
              <td></td>
              <td>被举报物品对应的用户id</td>
              <td></td>
              <td>举报内容</td>
              <td></td>
              <td>举报类型</td>
              <td></td>
              <td>操作</td>
              <td></td>
              <td>更新时间</td>
              <td></td>
              <td>创建时间</td>
          </tr>

              <tr>
                  <td>${list.userId}</td>
                  <td></td>
                  <td>${list.goodsId}</td>
                  <td></td>
                  <td>${list.informedUserId}</td>
                  <td></td>
                  <td>${list.content}</td>
                  <td></td>
                  <td>${list.type}</td>
                  <td></td>
                  <td>${list.status}</td>
                  <td></td>
                  <td>${list.updatedAt}</td>
                  <td></td>
                  <td>${list.createdAt}</td>
                  <td><a href="${ctx}/GoodsExchange/Inform/delete?id=${list.id}">删除</a></td>
              </tr>
          </table>
          </c:forEach>

</body>
</html>
