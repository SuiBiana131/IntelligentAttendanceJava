package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class MappointMapperServiceImpl implements MappointMapperService{
	@Autowired
	MappointMapper mappointMapper;
	@Override
	public Mappoint selectById(int id) {
		// TODO Auto-generated method stub
		return mappointMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		mappointMapper.deleteById(id);
	}

	@Override
	public void insert(Mappoint mappoint) {
		// TODO Auto-generated method stub
		mappointMapper.insert(mappoint);
	}

	@Override
	public void update(Mappoint mappoint) {
		// TODO Auto-generated method stub
		mappointMapper.update(mappoint);
	}
	@Override
	public List<Mappoint> selectAll() {
		// TODO Auto-generated method stub
		return mappointMapper.selectAll();
	}
	@Override
	public List<Mappoint> selectBygid(int id) {
		// TODO Auto-generated method stub
		return mappointMapper.selectBygid( id);
	}
}
