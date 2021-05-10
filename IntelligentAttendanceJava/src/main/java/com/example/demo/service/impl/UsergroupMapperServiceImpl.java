package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usergroup;
import com.example.demo.mapper.*;
import com.example.demo.service.UserAccommodationMapperService;
import com.example.demo.service.UsergroupMapperService;

@Service
public class UsergroupMapperServiceImpl implements UsergroupMapperService{
	@Autowired
	UsergroupMapper usergroupMapper;
	@Override
	public Usergroup selectById(int id) {
		// TODO Auto-generated method stub
		return usergroupMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		usergroupMapper.deleteById(id);
	}

	@Override
	public void insert(Usergroup usergroup) {
		// TODO Auto-generated method stub
		usergroupMapper.insert(usergroup);
	}

	@Override
	public void update(Usergroup usergroup) {
		// TODO Auto-generated method stub
		usergroupMapper.update(usergroup);
	}

	@Override
	public List<Usergroup> selectByGroupname(String groupname) {
		// TODO Auto-generated method stub
		return usergroupMapper.selectByGroupname(groupname);
	}

	@Override
	public List<String> selectNum() {
		// TODO Auto-generated method stub
		return usergroupMapper.selectNum();
	}

	@Override
	public Usergroup selectByusername(String username) {
		// TODO Auto-generated method stub
		return usergroupMapper.selectByusername(username);
	}

}
