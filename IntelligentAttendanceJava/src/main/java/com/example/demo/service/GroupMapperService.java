package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Group;

public interface GroupMapperService {
	Group selectById(String name);
	public void deleteById(String name);
	public void insert(Group group);
	public void update(Group group);
	List<Group> selectAll();
}
