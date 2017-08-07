package com.xj.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		// ������Ӧ��������
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();
		String title = "����̳� Error/Exception ��Ϣ";

		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		out.println("<h1>����̳��쳣��Ϣʵ����ʾ</h1>");
		if (throwable == null && statusCode == null) {
			out.println("<h2>������Ϣ��ʧ</h2>");
			out.println("�뷵�� <a href=\"" + resp.encodeURL("http://localhost:8080/") + "\">��ҳ</a>��");
		} else if (statusCode != null) {
			out.println("������� : " + statusCode);
		} else {
			out.println("<h2>������Ϣ</h2>");
			out.println("Servlet Name : " + servletName + "</br></br>");
			out.println("�쳣���� : " + throwable.getClass().getName() + "</br></br>");
			out.println("���� URI: " + requestUri + "<br><br>");
			out.println("�쳣��Ϣ: " + throwable.getMessage());
		}
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}