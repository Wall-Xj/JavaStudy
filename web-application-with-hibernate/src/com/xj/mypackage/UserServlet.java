package com.xj.mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");;
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		User u=new User();
		u.setEmail(email);
		u.setName(name);
		u.setPassword(password);
		int i = UserDao.save(u);
		if (i > 0) {
			PrintWriter out=resp.getWriter();
			out.print("You are successfully registered");
		}
	}
}
