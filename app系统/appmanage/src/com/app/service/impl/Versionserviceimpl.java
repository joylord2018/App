package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Versiondao;
import com.app.entity.Version;
import com.app.service.Versionservice;
@Service
public class Versionserviceimpl implements Versionservice{
@Autowired
private Versiondao vdao;

	public Versiondao getVdao() {
	return vdao;
}

public void setVdao(Versiondao vdao) {
	this.vdao = vdao;
}

	public Version findbyid(Integer id) {
		// TODO Auto-generated method stub
		return vdao.findbyid(id);
	}

	public List<Version> findbyappid(Integer appid) {
		// TODO Auto-generated method stub
		return vdao.findbyappid(appid);
	}

	public int add(Version ver) {
		// TODO Auto-generated method stub
		return vdao.add(ver);
	}

	public Version newappid(Integer appid) {
		// TODO Auto-generated method stub
		return vdao.newappid(appid);
	}

	public int update(Version ver) {
		// TODO Auto-generated method stub
		System.out.println(1);
		return vdao.update(ver);
	}

}
