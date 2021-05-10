package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;

public interface UsergroupMapperService {
	Usergroup selectById(int id);
	public void deleteById(int id);
	public void insert(Usergroup usergroup);
	public void update(Usergroup usergroup);
	
	List<Usergroup> selectByGroupname(String groupname);
	Usergroup selectByusername(String username);
	List<String> selectNum();
}
