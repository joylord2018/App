package com.app.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Backend_User;
import com.app.entity.Dev_User;
import com.app.service.Backend_Userservice;
import com.app.service.Categoryservice;
import com.app.service.Dev_Userservice;
import com.app.service.Dictionaryservice;

@Controller
public class Login {
	//管理员接口
	@Autowired
	private Backend_Userservice bus;
	
	public Backend_Userservice getBus() {
		return bus;
	}

	public void setBus(Backend_Userservice bus) {
		this.bus = bus;
	}
	//开发者接口
	@Autowired
	private Dev_Userservice dus;
	
	public Dev_Userservice getDus() {
		return dus;
	}
	public void setDus(Dev_Userservice dus) {
		this.dus = dus;
	}
	//三级菜单
	@Autowired
	private Categoryservice cs;
	
	public Categoryservice getCs() {
		return cs;
	}

	public void setCs(Categoryservice cs) {
		this.cs = cs;
	}
	//平台
	@Autowired
	private Dictionaryservice ds;
	public Dictionaryservice getDs() {
		return ds;
	}

	public void setDs(Dictionaryservice ds) {
		this.ds = ds;
	}
	@RequestMapping("index.html")
	public String fist(HttpSession session){
		ServletContext application =session.getServletContext();
		//所有分类的
		if(application.getAttribute("catename")==null){
			application.setAttribute("catename",cs.catename());	
		}
		//所有平台
		if(application.getAttribute("flatformId")==null){
			
			application.setAttribute("flatformId", ds.findbytype("APP_FLATFORM"));
		}
		//所有状态
		if(application.getAttribute("status")==null){	
			application.setAttribute("status", ds.findbytype("APP_STATUS"));
		}
		return "redirect:index.jsp";
	}
	/**
	 * 管理员登陆功能
	 * @param userCode
	 * @param userPassword
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping("backlogin.html")
	public String backendLogin(String userCode,String userPassword,Model m,HttpSession session){
		Backend_User bu=bus.login(userCode, userPassword);
		if(bu==null){
			m.addAttribute("error", "账号用户名错误");
			return "backendlogin";
		}
		session.setAttribute("admin", bu);
		return "backend/main";
	}
	/**
	 * 开发者登陆功能
	 * @param userCode
	 * @param userPassword
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping("devlogin.html")
	public String devLogin(String devCode,String devPassword,Model m,HttpSession session){
		Dev_User du=dus.login(devCode, devPassword);
		if(du==null){
			m.addAttribute("error", "账号用户名错误");
			return "devlogin";
		}
		session.setAttribute("dev", du);
		return "developer/main";
	}
	
	@ExceptionHandler(value=java.lang.Exception.class)
	public String getError(){
		return "403";
	}
}
