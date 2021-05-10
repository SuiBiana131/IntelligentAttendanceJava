package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Oadesigner;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserMapperService;

@Service
public class UserMapperServiceImpl implements UserMapperService{
	@Autowired
	UserMapper userMapper;
	@Override
	public User selectById(int userid) {
		// TODO Auto-generated method stub
		return userMapper.selectById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		userMapper.deleteById(userid);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	@Override
	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(name);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

	@Override
	public List<Oadesigner> test(int id) {
		// TODO Auto-generated method stub
		return userMapper.test(id);
	}

}
