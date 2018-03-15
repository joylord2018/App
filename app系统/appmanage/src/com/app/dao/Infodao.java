package com.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Info;
import com.app.util.Infovo;
import com.sun.org.glassfish.gmbal.ParameterNames;


public interface Infodao {
public List<Info> infopage(@Param("index") Integer index,@Param("pagesize")Integer pagesize,@Param("Infovo") Infovo vo );
public int maxCount(@Param("Infovo") Infovo vo);
public Info findbyid(@Param("id")Integer id,@Param("devid")Integer devid);
public int check(@Param("id")Integer id,@Param("st")Integer st);
public int add(@Param("infoer")Info infoer);
public List<Info> infoye(@Param("index") Integer index,@Param("pagesize")Integer pagesize,@Param("Infovo") Infovo vo );
public int update(@Param("infer")Info in);
}