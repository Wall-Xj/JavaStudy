package com.xj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTrack extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Date createTimne = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String title = "Servlet Session ʵ�� - ����̳�";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("Runoob");

		if (session.isNew()) {
			title = "Servlet Session ʵ�� - ����̳�";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount += 1;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);

		// ������Ӧ��������
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<h2 align=\"center\">Session ��Ϣ</h2>\n" + "<table border=\"1\" align=\"center\">\n"
				+ "<tr bgcolor=\"#949494\">\n" + "  <th>Session ��Ϣ</th><th>ֵ</th></tr>\n" + "<tr>\n" + "  <td>id</td>\n"
				+ "  <td>" + session.getId() + "</td></tr>\n" + "<tr>\n" + "  <td>����ʱ��</td>\n" + "  <td>"
				+ df.format(createTimne) + "  </td></tr>\n" + "<tr>\n" + "  <td>������ʱ��</td>\n" + "  <td>"
				+ df.format(lastAccessTime) + "  </td></tr>\n" + "<tr>\n" + "  <td>�û� ID</td>\n" + "  <td>" + userID
				+ "  </td></tr>\n" + "<tr>\n" + "  <td>����ͳ�ƣ�</td>\n" + "  <td>" + visitCount + "</td></tr>\n"
				+ "</table>\n" + "</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
