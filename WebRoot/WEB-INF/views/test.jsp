<%--
  Created by IntelliJ IDEA.
  User: fafukeji_java
  Date: 2015/7/23
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <script src="${ctxStatic}/jquery/jquery-2.0.3.min.js"></script>
    <script src="${ctxStatic}/js/parsley.min.js"></script>
    <script src="${ctxStatic}/js/zh_cn.js"></script>
    <title></title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>

<%--<h1>springform验证:</h1>--%>
<%--<form:form action="${ctx}/admin/saveUser" method="post" modelAttribute="user">--%>
    <%--用户名<input type="text" name="username">--%>
    <%--<form:errors path="username" cssClass="error"/>--%>
    <%--<input type="submit" value="submit">--%>
<%--</form:form>--%>

<%--<h1>普通form验证:</h1>--%>
<%--<form id="form" action="${ctx}/admin/saveUser" method="post" data-parsley-validate>--%>
    <%--id:<input type="text" name="id" data-parsley-minlength="[6]" data-parsley-minlength-message="用户长度不能低于6" required><br>--%>
    <%--email:<input type="email" name="email" data-parsley-trigger="change" required /><br>--%>
    <%--<textarea name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-validation-threshold="10" data-parsley-minlength-message = "输入内容必须大于20">--%>
    <%--</textarea>--%>
    <%--<input type="submit" value="submit">--%>
<%--</form>--%>11111111111111


</body>
</html>
