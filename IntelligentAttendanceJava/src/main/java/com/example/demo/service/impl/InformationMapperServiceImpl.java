package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Information;
import com.example.demo.mapper.InformationMapper;
import com.example.demo.service.InformationMapperService;

@Service
public class InformationMapperServiceImpl implements InformationMapperService{
	@Autowired
	InformationMapper InformationMapper;
	
	@Override
	public Information selectById(int userid) {
		// TODO Auto-generated method stub
		Information information= InformationMapper.selectById(userid);
		return information;
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		InformationMapper.deleteById(userid);
	}

	@Override
	public void insert(Information information) {
		// TODO Auto-generated method stub
		InformationMapper.insert(information);
	}

	@Override
	public void update(Information information) {
		// TODO Auto-generated method stub
		InformationMapper.update(information);
	}

	@Override
	public Information selectName(String username) {
		// TODO Auto-generated method stub
		return InformationMapper.selectName(username);
	}

	@Override
	public List<Information> selectAll() {
		// TODO Auto-generated method stub
		return InformationMapper.selectAll();
	}

	@Override
	public List<Information> selectCondition(Map map) {
		// TODO Auto-generated method stub
		return InformationMapper.selectCondition(map);
	}
	

}
