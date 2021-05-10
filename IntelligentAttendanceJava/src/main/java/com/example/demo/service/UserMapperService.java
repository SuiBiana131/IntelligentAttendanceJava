package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Oadesigner;
import com.example.demo.entity.User;

public interface UserMapperService {
	User selectById(int userid);
	User selectByName(String name);
	public void deleteById(int userid);
	public void insert(User user);
	public void update(User usser);
	List<User> selectAll();
	List<Oadesigner> test(int id);
}
