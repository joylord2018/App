package com.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Version;


public interface Versiondao {
	public Version findbyid(@Param("id") Integer id);
	public List<Version> findbyappid(@Param("appid") Integer appid);
	public int add(@Param("ver")Version ver);
	public Version newappid(@Param("appid") Integer appid);
	public int update(@Param("ver") Version ver);
}