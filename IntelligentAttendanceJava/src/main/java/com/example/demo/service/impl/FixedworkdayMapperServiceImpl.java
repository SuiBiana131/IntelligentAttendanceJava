package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;
@Service
public class FixedworkdayMapperServiceImpl implements FixedworkdayMapperService{
	@Autowired
	FixedworkdayMapper fixedworkdayMapper;
	@Override
	public Fixedworkday selectById(int id) {
		// TODO Auto-generated method stub
		return fixedworkdayMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		fixedworkdayMapper.deleteById(id);
	}

	@Override
	public void insert(Fixedworkday fixedworkday) {
		// TODO Auto-generated method stub
		fixedworkdayMapper.insert(fixedworkday);
	}

	@Override
	public void update(Fixedworkday fixedworkday) {
		// TODO Auto-generated method stub
		fixedworkdayMapper.update(fixedworkday);
	}
	@Override
	public List<Fixedworkday> selectAll() {
		// TODO Auto-generated method stub
		return fixedworkdayMapper.selectAll();
	}

	@Override
	public List<Fixedworkday> selectBygid(int id) {
		// TODO Auto-generated method stub
		return fixedworkdayMapper.selectBygid(id);
	}
}
