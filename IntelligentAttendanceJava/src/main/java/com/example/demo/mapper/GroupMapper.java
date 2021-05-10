package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.*;

public interface GroupMapper {
	Group selectById(String name);
	public void deleteById(String name);
	public void insert(Group group);
	public void update(Group group);
	List<Group> selectAll();
}
