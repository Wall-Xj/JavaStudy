package com.xj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String auto = req.getParameter("auto");

		String username = req.getParameter("name");
		String password = req.getParameter("pwd");
		if (auto != null && auto.equals("1")) {
			Cookie c = new Cookie("username", username);
			Cookie c1 = new Cookie("password", password);
			c.setMaxAge(60 * 60);
			c1.setMaxAge(60 * 60);
			resp.addCookie(c);
			resp.addCookie(c1);
			resp.getWriter().println(username);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
