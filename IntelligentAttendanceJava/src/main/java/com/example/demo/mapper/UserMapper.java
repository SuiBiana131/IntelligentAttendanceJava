package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Oadesigner;
import com.example.demo.entity.User;

public interface UserMapper {
	User selectById(int userid);
	User selectByName(String name);
	public void deleteById(int userid);
	public void insert(User user);
	public void update(User user);
	List<User> selectAll();
	List<Oadesigner> test(int id);
}
