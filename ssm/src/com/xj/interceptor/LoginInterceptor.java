package com.xj.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> allowedPass;
	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handle, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handle, ModelAndView mv)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
		Object user=req.getSession().getAttribute("user");
		if(user!=null) {
			return true;
		}
		String url=req.getRequestURI();
		for(String temp :allowedPass) {
			if(url.endsWith(temp)) {
				return true;
			}
		}
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		return false;
	}

}
