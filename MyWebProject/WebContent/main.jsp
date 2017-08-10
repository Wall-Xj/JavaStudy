<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:include page="date.jsp" flush="true" />--%>

	<h2>Jsp 使用 JavaBean 实例</h2>
	<jsp:useBean id="test" class="com.xj.main.TestBean"/>
	<jsp:setProperty name="test" property="message" value="菜鸟教程。。。"/>
	<p>输出信息...</p>
	<jsp:getProperty name="test" property="message"/>
	
	<jsp:forward page="Upload.jsp"/>
	
</body>
</html>