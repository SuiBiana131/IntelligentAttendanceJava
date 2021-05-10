package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.*;

public interface ClassmanageMapper {
	Classmanage selectById(int id);
	public void deleteById(int id);
	public void insert(Classmanage classmanage);
	public void update(Classmanage classmanage);
	List<Classmanage> selectAll();
}
