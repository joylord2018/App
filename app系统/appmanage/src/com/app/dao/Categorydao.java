package com.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Category;

public interface Categorydao {
public List<Category> catename();
public List<Category> bypid(@Param("pid") Integer pid);
}