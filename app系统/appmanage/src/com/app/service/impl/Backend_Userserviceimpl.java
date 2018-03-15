package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.Backend_Userdao;
import com.app.entity.Backend_User;
import com.app.service.Backend_Userservice;
@Service("BUService")
public class Backend_Userserviceimpl implements Backend_Userservice{
	@Autowired
	private Backend_Userdao budao;
/**
 * 提供get,set方法用来注入
 * @return
 */
	public Backend_Userdao getBudao() {
	return budao;
	}

	public void setBudao(Backend_Userdao budao) {
		this.budao = budao;
	}
	/**
	 * 管理员登陆
	 */
	public Backend_User login(String usercode, String password) {
		// TODO Auto-generated method stub
		return budao.login(usercode, password);
	}

}
