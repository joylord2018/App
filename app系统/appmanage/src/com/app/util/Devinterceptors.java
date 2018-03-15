package com.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.entity.Dev_User;

public class Devinterceptors extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Dev_User du=(Dev_User)request.getSession().getAttribute("dev");
		if(du==null){
			response.sendRedirect(request.getContextPath()+"/devlogin.jsp");
			return false;
		}
		return true;
	}

}
