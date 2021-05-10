package com.example.demo.mapper;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.*;

public interface UsergroupMapper {
	Usergroup selectById(int id);
	public void deleteById(int id);
	public void insert(Usergroup usergroup);
	public void update(Usergroup usergroup);
	
	List<Usergroup> selectByGroupname(String groupname);
	Usergroup selectByusername(String username);
	List<String> selectNum();
}
