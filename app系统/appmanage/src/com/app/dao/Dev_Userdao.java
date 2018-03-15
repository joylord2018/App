package com.app.dao;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Dev_User;


public interface Dev_Userdao {
public Dev_User login(@Param("devcode") String devcode,@Param("password") String devpassword);
}