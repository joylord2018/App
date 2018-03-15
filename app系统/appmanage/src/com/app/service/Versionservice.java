package com.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Version;


public interface Versionservice {
	public Version findbyid(Integer id);
	public List<Version> findbyappid(Integer appid);
	public int add(Version ver);
	public Version newappid(Integer appid);
	public int update(Version ver);
}