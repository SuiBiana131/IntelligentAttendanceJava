package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Group;
import com.example.demo.mapper.*;
import com.example.demo.service.GroupMapperService;

@Service
public class GroupMapperServiceImpl implements GroupMapperService{
	@Autowired
	GroupMapper groupMapper;
	
	@Override
	public Group selectById(String name) {
		// TODO Auto-generated method stub
		return groupMapper.selectById(name);
	}

	@Override
	public void deleteById(String name) {
		// TODO Auto-generated method stub
		groupMapper.deleteById(name);
	}

	@Override
	public void insert(Group group) {
		// TODO Auto-generated method stub
		groupMapper.insert(group);
	}

	@Override
	public void update(Group group) {
		// TODO Auto-generated method stub
		groupMapper.update(group);
	}
	@Override
	public List<Group> selectAll() {
		// TODO Auto-generated method stub
		return groupMapper.selectAll();
	}
}
