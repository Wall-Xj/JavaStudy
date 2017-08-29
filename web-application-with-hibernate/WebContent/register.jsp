
<%@ page import="com.xj.mypackage.UserDao"%>

<jsp:useBean id="obj" class="com.xj.mypackage.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj" />

<%
	int i = UserDao.save(obj);
	if (i > 0) {
		out.print("You are successfully registered");
	}
%>
