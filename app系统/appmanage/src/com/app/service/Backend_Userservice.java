package com.app.service;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Backend_User;

public interface Backend_Userservice {
	public Backend_User login(String usercode,String password);
}
