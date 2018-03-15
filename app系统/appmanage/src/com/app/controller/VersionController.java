package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Dev_User;
import com.app.entity.Info;
import com.app.entity.Version;
import com.app.service.Infoservice;
import com.app.service.Versionservice;
@Controller
@RequestMapping("/developer")
public class VersionController {
@Autowired
private Versionservice vs;
	

	public Versionservice getVs() {
	return vs;
}


public void setVs(Versionservice vs) {
	this.vs = vs;
}
@Autowired
private Infoservice is;

	public Infoservice getIs() {
	return is;
}


public void setIs(Infoservice is) {
	this.is = is;
}


	@RequestMapping("verid.html")
	public String verid(Integer id,Integer sid,Model m,HttpSession session){
		List<Version> li=vs.findbyappid(id);
		Dev_User du=(Dev_User) session.getAttribute("dev");
		Version ver=vs.newappid(id);
		switch (sid) {
		case 1:
		m.addAttribute("appid",id);
		m.addAttribute("li", li);
			return "developer/appversionadd";
		case 2:
		m.addAttribute("appid",id);
		m.addAttribute("li2", li);
		m.addAttribute("newver",ver);
			return "developer/appversionmodify";
		case 3:
			Info in=is.findbyid(id, du.getId());
			m.addAttribute("in",in);
			return "developer/appinfomodify";
		case 4:
			return "developer/appinfoview";
		}
		return "";
	}
	
	
	@RequestMapping("addver.html")
	public String addver(@Valid Version ver,BindingResult br,Model m,MultipartFile apk,HttpSession session){
		
		if(br.hasErrors()){
			List<FieldError> lierror=br.getFieldErrors();
			for(FieldError fe:lierror){
				session.setAttribute(fe.getField()+"error",fe.getDefaultMessage());
			}
			return "redirect:verid.html?id="+ver.getAppid()+"&sid=1";
		}
		String path=session.getServletContext().getRealPath("/statics/uploadfiles");
		String apkname=apk.getOriginalFilename();
		
		String type=apkname.substring(apkname.lastIndexOf(".")+1).toLowerCase();
		if(!type.equals("apk")){
			session.setAttribute("fileerror", "文件格式不正确");
			return "redirect:verid.html?id="+ver.getAppid()+"&sid=1";
		}
		if(apk.getSize()>1024*1024*100){
			session.setAttribute("fileerror", "文件格式不能超过100M");
			return "redirect:verid.html?id="+ver.getAppid()+"&sid=1";
		}
		String downloadlink="/statics/uploadfiles/"+apkname;
		String apklocpath=path+"/"+apkname;
		File fileapk=new File(apklocpath);
		if(fileapk.exists()){
			session.setAttribute("fileerror", "该文件已存在请确认apk名称");
			
			return "redirect:verid.html?id="+ver.getAppid()+"&sid=1";
		}
		try {
			apk.transferTo(fileapk);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ver.setApkfilename(apkname);
		ver.setApklocpath(apklocpath);
		ver.setDownloadlink(downloadlink);
		ver.setCreationdate(new Date());
		int res=vs.add(ver);
		if(res<=0){
			return "403";
		}
		return "redirect:../backend/infoye.html";
	}
	
	@RequestMapping("updateversion.html")
	public String updatever(@Valid Version ver,BindingResult br,Model m,MultipartFile apk,HttpSession session){
		System.out.println(ver.getVersioninfo());
		if(br.hasErrors()){
			List<FieldError> lierror=br.getFieldErrors();
			for(FieldError fe:lierror){
				session.setAttribute(fe.getField()+"error",fe.getDefaultMessage());
			}
			System.out.println(1);
			return "redirect:verid.html?id="+ver.getAppid()+"&sid=2";
		}
		if(apk!=null&&!apk.getOriginalFilename().equals("")){
			String path=session.getServletContext().getRealPath("/statics/uploadfiles");
			String apkname=apk.getOriginalFilename();
			String type=apkname.substring(apkname.lastIndexOf(".")+1).toLowerCase();
			if(!type.equals("apk")){
				session.setAttribute("fileerror", "文件格式不正确");
				System.out.println(2);
				return "redirect:verid.html?id="+ver.getAppid()+"&sid=2";
			}
			if(apk.getSize()>1024*1024*100){
				session.setAttribute("fileerror", "文件格式不能超过100M");
				return "redirect:verid.html?id="+ver.getAppid()+"&sid=2";
			}
			String downloadlink="/statics/uploadfiles/"+apkname;
			String apklocpath=path+"/"+apkname;
			File fileapk=new File(apklocpath);
			if(fileapk.exists()){
				session.setAttribute("fileerror", "该文件已存在请确认apk名称");
				return "redirect:verid.html?id="+ver.getAppid()+"&sid=2";
			}
			try {
				apk.transferTo(fileapk);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ver.setApkfilename(apkname);
			ver.setApklocpath(apklocpath);
			ver.setDownloadlink(downloadlink);
		}
		ver.setModifydate(new Date());
		Dev_User du=(Dev_User) session.getAttribute("dev");
		ver.setModifyby(du.getId());
		int res=vs.update(ver);
		if(res<=0){
			return "403";
		}
		return "redirect:../backend/infoye.html";
	}
	
	@RequestMapping("updateinfo.html")
	public String updateinfo(Info in){
		int res=is.update(in);
		
		return "redirect:../backend/infoye.html";
	}
}
