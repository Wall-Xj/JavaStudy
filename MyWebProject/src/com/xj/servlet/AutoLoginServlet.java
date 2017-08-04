package com.xj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cs = req.getCookies();
		if (cs != null && cs.length > 0) {
			for (Cookie c : cs) {
				if (c.getName().equals("username")) {
					req.setAttribute("un", c.getValue());
				}
				if (c.getName().equals("password")) {
					req.setAttribute("pw", c.getValue());
				}
			}
			
			
		}
		
		
		req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
