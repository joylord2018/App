package com.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Dev_User;
import com.app.entity.Info;
import com.app.entity.Version;
import com.app.service.Infoservice;
import com.app.service.Versionservice;
import com.app.util.Infovo;
import com.app.util.PageUtil;

@Controller
@RequestMapping("/backend")
public class Infocontroller {
private List<String> li=Arrays.asList("jpg","png","jpeg","gif");
@Autowired
private Infoservice is;
@Autowired
private Versionservice vs;

public Versionservice getVs() {
	return vs;
}

public void setVs(Versionservice vs) {
	this.vs = vs;
}

public Infoservice getIs() {
	return is;
}

public void setIs(Infoservice is) {
	this.is = is;
}

@RequestMapping("infopage.html")
public String page(Integer pageno, Integer pagesize,Infovo vo,Model m){
	PageUtil<Info, Info> pu=is.infopage(pageno, pagesize, vo);
	m.addAttribute("pu",pu);
	m.addAttribute("vo",vo);
	return "backend/applist";
}
@RequestMapping("byid.html")
public String findbyid(Integer id,Integer devid,Model m){
	Info in=is.findbyid(id,devid);
	Version v=vs.findbyid(id);
	m.addAttribute("in", in);
	m.addAttribute("v", v);
	return "backend/appcheck";
}
@RequestMapping("download.html")
public void download(String fpath,HttpSession session,HttpServletResponse response,HttpServletRequest request){
	String path=session.getServletContext().getRealPath("/"+fpath);
	if(fpath==null||fpath.equals("")){
		try {
			response.sendRedirect(session.getServletContext().getRealPath("/")+"403.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	File file=new File(path);
	if(!file.exists()){
		return;
	}
	InputStream fis=null;
	OutputStream fos=null;
	try {
		fis=new FileInputStream(file);
		response.setHeader("content-disposition", "attachment;filename="  
		        + URLEncoder.encode(path, "UTF-8"));
		fos=response.getOutputStream();
		byte[] bytes=new byte[2048];
		int length=0;
		while((length=fis.read(bytes))>0){
			fos.flush();
			fos.write(bytes, 0, length);
		}
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

@RequestMapping("check.html")
@ResponseBody
public String check(Integer id,Integer st){
	int res=is.check(id, st);
	if(res>0){
		return "操作成功";
	}
	return "操作失败";
}
@RequestMapping("addinfo.html")
public String add(@Valid Info vo,BindingResult br,MultipartFile pic,Model m,HttpSession session){
	if(br.hasErrors()){
		List<FieldError> li=br.getFieldErrors();
		for(FieldError fe:li){
			m.addAttribute(fe.getField()+"error",fe.getDefaultMessage());
		}
		return "forward:../developer/appinfoadd.jsp";
		}
	if(pic.isEmpty()){
		m.addAttribute("error","图片不能为空");
		return "forward:../developer/appinfoadd.jsp";
	}
	if(pic.getSize()>1024*1024){
		m.addAttribute("error","图片大小不能超过1M");
		return "forward:../developer/appinfoadd.jsp";
	}
	String a=pic.getOriginalFilename();
	//获取文件后缀名
	String type=a.substring(a.lastIndexOf(".")+1).toLowerCase();
	if(!li.contains(type)){
		m.addAttribute("error","图片格式只能为jpg,png,jpeg,gif");
		return "forward:../developer/appinfoadd.jsp";
	}
	//指定文件路径
	String path=session.getServletContext().getRealPath("/statics/images");
	String picname=UUID.randomUUID().toString().replace("-","").toLowerCase()+"."+type;
	String filename=path+"/"+picname;
	String piclocalname="/statics/images/"+picname;
	File file=new File(filename);
	try {
		pic.transferTo(file);
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Dev_User du=(Dev_User) session.getAttribute("dev");
	vo.setDevid(du.getId());
	vo.setCreationdate(new Date());
	vo.setLogopicpath(piclocalname);
	vo.setLogolocpath(filename);
	int res=is.add(vo);
	if(res<0){
		return "forward:../developer/appinfoadd.jsp";
	}
	
	return "redirect:infoye.html";
}

@RequestMapping("infoye.html")
public String infoye(Integer pageno, Integer pagesize,Infovo vo,Model m,HttpSession session){
	Dev_User du=(Dev_User)session.getAttribute("dev");
	vo.setDevid(du.getId());
	PageUtil<Info, Info> pu=is.infoye(pageno, pagesize, vo);
	m.addAttribute("pu",pu);
	m.addAttribute("vo",vo);
	return "forward:../developer/appinfolist.jsp";
}
}
