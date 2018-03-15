package com.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.entity.Backend_User;

public class Backendinterceptors extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		Backend_User bu=(Backend_User)request.getSession().getAttribute("admin");
		if(bu==null){
			response.sendRedirect(request.getContextPath()+"/backendlogin.jsp");
			return false;
		}
		return true;
	}

}
