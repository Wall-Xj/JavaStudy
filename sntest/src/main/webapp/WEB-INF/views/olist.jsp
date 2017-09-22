<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>欢迎：${loggedinuser.realName}  <a href="/plist">返回</a> </h2>
	<table width="80%" align="center">
		<thead>
			<tr>
				<td>订单编号</td>
				<td>商品名称</td>
				<td>用户名</td>
				<td>下单时间</td>
				<td>操    作</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${olist }" var="bean">
			<tr>
			<td>${bean.id }</td>
			<td>${bean.productName }</td>
			<td>${bean.realName }</td>
			<td>${bean.createTime }</td>
			<td><a href="<c:url value='/deleteOrder-${bean.id}' />" >删除</a></td>
			</tr>
		 </c:forEach>
		</tbody>
	</table>

</body>
</html>