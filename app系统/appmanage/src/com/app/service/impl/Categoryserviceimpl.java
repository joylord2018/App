package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Categorydao;
import com.app.entity.Category;
import com.app.service.Categoryservice;
@Service("cateService")
public class Categoryserviceimpl implements Categoryservice{
	@Autowired
	private Categorydao cdao;
	
	public Categorydao getCdao() {
		return cdao;
	}

	public void setCdao(Categorydao cdao) {
		this.cdao = cdao;
	}
//获得所有分类
	public List<Category> catename() {
		// TODO Auto-generated method stub
		return cdao.catename();
	}

	public List<Category> bypid(Integer pid) {
		// TODO Auto-generated method stub
		return cdao.bypid(pid);
	}

	
}
