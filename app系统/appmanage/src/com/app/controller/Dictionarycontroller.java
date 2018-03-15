package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.Category;
import com.app.entity.Dictionary;
import com.app.service.Categoryservice;
import com.app.service.Dictionaryservice;
import com.app.service.impl.Categoryserviceimpl;

@Controller
@RequestMapping("/backend")
public class Dictionarycontroller {
	@Autowired
	private Dictionaryservice ds;

	public Dictionaryservice getDs() {
		return ds;
	}
	public void setDs(Dictionaryservice ds) {
		this.ds = ds;
	}
	@Autowired
	private Categoryservice cs;
	
	public Categoryservice getCs() {
		return cs;
	}
	public void setCs(Categoryservice cs) {
		this.cs = cs;
	}
	@RequestMapping("findbytype.html")
	@ResponseBody
	public List<Dictionary> findbytype(String typeCode){
		List<Dictionary> li=ds.findbytype(typeCode);
		return li;
	}
	
	@RequestMapping("findcate.html")
	@ResponseBody
	public List<Category> findcate(HttpSession session){
		ServletContext application=session.getServletContext();
		List<Category> lic=(List<Category>)application.getAttribute("catename");
		return lic;
	}
	@RequestMapping("findcatepid.html")
	@ResponseBody
	public List<Category> findcatepid(Integer pid){
		
		List<Category> lic=cs.bypid(pid);
		return lic;
	}
}
