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
	<h2>欢迎：${loggedinuser.realName}  <a href="/olist">订单列表</a></h2>
	<table width="80%" align="center">
		<thead>
			<tr>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>操作a</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${plist }" var="bean">
			<tr>
			<td>${bean.id }</td>
			<td>${bean.productName }</td>
			<td><a href="<c:url value='/createOrder-${bean.id}' />" >下单</a></td>
			</tr>
		 </c:forEach>
		</tbody>
	</table>

</body>
</html>