package com.app.dao;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Backend_User;


public interface Backend_Userdao {
public Backend_User login(@Param("usercode") String usercode,@Param("password") String password);
}