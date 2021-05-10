package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class ClassmanageMapperServiceImpl implements  ClassmanageMapperService{
	@Autowired
	ClassmanageMapper classmanageMapper;
	@Override
	public Classmanage selectById(int id) {
		// TODO Auto-generated method stub
		return classmanageMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		classmanageMapper.deleteById(id);
	}

	@Override
	public void insert(Classmanage classmanage) {
		// TODO Auto-generated method stub
		classmanageMapper.insert(classmanage);
	}

	@Override
	public void update(Classmanage classmanage) {
		// TODO Auto-generated method stub
		classmanageMapper.update(classmanage);
	}

	@Override
	public List<Classmanage> selectAll() {
		// TODO Auto-generated method stub
		return classmanageMapper.selectAll();
	}

}
