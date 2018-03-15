package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Dev_Userdao;
import com.app.entity.Dev_User;

import com.app.service.Dev_Userservice;
@Service("DUService")
public class Dev_Userserviceimpl implements Dev_Userservice{
	@Autowired
	private Dev_Userdao dudao;
/**
 * 提供get,set方法用来注入
 * @return
 */

	public Dev_Userdao getDudao() {
		return dudao;
	}

	public void setDudao(Dev_Userdao dudao) {
		this.dudao = dudao;
	}
	/**--------------------------------------------
	 * 管理员登陆
	 */
	public Dev_User login(String usercode, String password) {
		// TODO Auto-generated method stub
		return dudao.login(usercode, password);
	}


}
