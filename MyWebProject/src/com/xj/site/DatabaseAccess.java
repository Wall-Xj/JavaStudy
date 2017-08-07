package com.xj.site;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xj.utils.DBManager;

public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String title = "Servlet Mysql 测试 - 菜鸟教程";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n");

		Connection conn = DBManager.getConn();
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id, name, url FROM websites";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				// 输出数据
				out.println("ID: " + id);
				out.println(", 站点名称: " + name);
				out.println(", 站点 URL: " + url);
				out.println("<br />");
			}
			out.println("</body></html>");
			DBManager.close(rs, stat, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
