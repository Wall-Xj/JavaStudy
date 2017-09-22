<%--
  Created by IntelliJ IDEA.
  User: WanYin
  Date: 2017/9/21
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order</title>
</head>
<body>
    <table width="80%" align="center">
        <tr>
            <td>用户名：</td>
            <td>${order.realName}</td>
        </tr>
        <tr>
            <td>商品名：</td>
            <td>${order.productName}</td>
        </tr>
        <tr>
            <td>下单时间：</td>
            <td>${order.createTime}</td>
        </tr>

    </table>
</body>
</html>
