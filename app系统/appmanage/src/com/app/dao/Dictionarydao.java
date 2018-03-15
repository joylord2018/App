package com.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.entity.Dictionary;

public interface Dictionarydao {
public List<Dictionary> findbytype(@Param("typeCode") String typeCode);
}