package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class MustworkdayMapperServiceImpl implements MustworkdayMapperService{
	@Autowired
	MustworkdayMapper mustworkdayMapper;
	@Override
	public Mustworkday selectById(int id) {
		// TODO Auto-generated method stub
		return mustworkdayMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		mustworkdayMapper.deleteById(id);
	}

	@Override
	public void insert(Mustworkday mustworkday) {
		// TODO Auto-generated method stub
		mustworkdayMapper.insert(mustworkday);
	}

	@Override
	public void update(Mustworkday mustworkday) {
		// TODO Auto-generated method stub
		mustworkdayMapper.update(mustworkday);
	}
	@Override
	public List<Mustworkday> selectAll() {
		// TODO Auto-generated method stub
		return mustworkdayMapper.selectAll();
	}
	@Override
	public List<Mustworkday> selectBygid(int id) {
		// TODO Auto-generated method stub
		return mustworkdayMapper.selectBygid(id);
	}
}
