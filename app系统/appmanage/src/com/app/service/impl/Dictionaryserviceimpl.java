package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Dictionarydao;
import com.app.entity.Dictionary;
import com.app.service.Dictionaryservice;
@Service("DicService")
public class Dictionaryserviceimpl implements Dictionaryservice{
	@Autowired
	private Dictionarydao ddao;
	public Dictionarydao getDdao() {
		return ddao;
	}
	public void setDdao(Dictionarydao ddao) {
		this.ddao = ddao;
	}
//按种类查询字典表
	public List<Dictionary> findbytype(String typeCode) {
		// TODO Auto-generated method stub
		return ddao.findbytype(typeCode);
	}

}
