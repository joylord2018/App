package com.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Info;
import com.app.util.Infovo;
import com.app.util.PageUtil;


public interface Infoservice {
	public PageUtil<Info, Info> infopage(Integer pageno,Integer pagesize,Infovo vo);
	public Info findbyid(Integer id,Integer devid);
	public int check(Integer id,Integer st);
	public int add(Info infoer);
	public PageUtil<Info, Info> infoye(Integer pageno,Integer pagesize,Infovo vo);
	public int update(Info in);
}