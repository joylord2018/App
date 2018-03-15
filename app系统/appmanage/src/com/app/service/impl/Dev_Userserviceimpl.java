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
 * �ṩget,set��������ע��
 * @return
 */

	public Dev_Userdao getDudao() {
		return dudao;
	}

	public void setDudao(Dev_Userdao dudao) {
		this.dudao = dudao;
	}
	/**--------------------------------------------
	 * ����Ա��½
	 */
	public Dev_User login(String usercode, String password) {
		// TODO Auto-generated method stub
		return dudao.login(usercode, password);
	}


}
