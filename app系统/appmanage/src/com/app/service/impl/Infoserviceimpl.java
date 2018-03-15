package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Infodao;
import com.app.entity.Info;
import com.app.service.Infoservice;
import com.app.util.Infovo;
import com.app.util.PageUtil;
@Service("infoservice")
public class Infoserviceimpl implements Infoservice{
	@Autowired
	private Infodao idao;
	
	public Infodao getIdao() {
		return idao;
	}

	public void setIdao(Infodao idao) {
		this.idao = idao;
	}

	public PageUtil<Info, Info> infopage(Integer pageno, Integer pagesize,Infovo vo) {
		// TODO Auto-generated method stub
		PageUtil<Info, Info> pu=new PageUtil<Info, Info>();
		pagesize=3;
		if(pageno==null){
			pageno=1;
		}
		pu.setPageNo(pageno);
		pu.setPageSize(pagesize);
		pu.setMaxCount(idao.maxCount(vo));
		pu.setList(idao.infopage((pageno-1)*pagesize, pagesize, vo));
		return pu;
	}

	public Info findbyid(Integer id,Integer devid) {
		// TODO Auto-generated method stub
		return idao.findbyid(id,devid);
	}

	public int check(Integer id, Integer st) {
		// TODO Auto-generated method stub
		return idao.check(id, st);
	}

	public int add(Info infoer) {
		// TODO Auto-generated method stub
		return idao.add(infoer);
	}

	public PageUtil<Info, Info> infoye(Integer pageno, Integer pagesize,Infovo vo) {
		PageUtil<Info, Info> pu=new PageUtil<Info, Info>();
		pagesize=3;
		if(pageno==null){
			pageno=1;
		}
		pu.setPageNo(pageno);
		pu.setPageSize(pagesize);
		pu.setMaxCount(idao.maxCount(vo));
		pu.setList(idao.infoye((pageno-1)*pagesize, pagesize, vo));
		return pu;
	}

	public int update(Info in) {
		// TODO Auto-generated method stub
		return idao.update(in);
	}
}
