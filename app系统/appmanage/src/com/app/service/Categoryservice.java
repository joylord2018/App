package com.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Category;

public interface Categoryservice {
public List<Category> catename();
public List<Category> bypid(Integer pid);
}