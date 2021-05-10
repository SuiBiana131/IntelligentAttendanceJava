package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class NotworkdayMapperServiceImpl implements NotworkdayMapperService{
	@Autowired
	NotworkdayMapper notworkdayMapper;
	@Override
	public Notworkday selectById(int id) {
		// TODO Auto-generated method stub
		return notworkdayMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		notworkdayMapper.deleteById(id);
	}

	@Override
	public void insert(Notworkday notworkday) {
		// TODO Auto-generated method stub
		notworkdayMapper.insert(notworkday);
	}

	@Override
	public void update(Notworkday notworkday) {
		// TODO Auto-generated method stub
		notworkdayMapper.update(notworkday);
	}
	@Override
	public List<Notworkday> selectAll() {
		// TODO Auto-generated method stub
		return notworkdayMapper.selectAll();
	}
	@Override
	public List<Notworkday> selectBygid(int id) {
		// TODO Auto-generated method stub
		return notworkdayMapper.selectBygid(id);
	}
}
