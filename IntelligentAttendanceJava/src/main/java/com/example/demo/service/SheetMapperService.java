package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Sheet;

public interface SheetMapperService {
	Sheet selectById(int id);
	public void deleteById(int id);
	public void insert(Sheet sheet);
	public void update(Sheet sheet);
	List<Sheet> selectAll();
	List<Sheet> selectAllByUse();
	List<Sheet> selectAllByNotuse();	
}
