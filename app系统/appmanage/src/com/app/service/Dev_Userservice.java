package com.app.service;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Dev_User;


public interface Dev_Userservice {
	public Dev_User login(String devcode,String devpassword);
}