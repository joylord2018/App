package com.app.service;

import java.util.List;

import com.app.entity.Dictionary;

public interface Dictionaryservice {
	public List<Dictionary> findbytype(String typeCode);
}