package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class HoildayMapperServiceImpl implements HoildayMapperService{
	@Autowired
	HoildayMapper hoildayMapper;
	@Override
	public Hoilday selectById(int id) {
		// TODO Auto-generated method stub
		return hoildayMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		hoildayMapper.deleteById(id);
	}

	@Override
	public void insert(Hoilday hoilday) {
		// TODO Auto-generated method stub
		hoildayMapper.insert(hoilday);
	}

	@Override
	public void update(Hoilday hoilday) {
		// TODO Auto-generated method stub
		hoildayMapper.update(hoilday);
	}
	@Override
	public List<Hoilday> selectAll() {
		// TODO Auto-generated method stub
		return hoildayMapper.selectAll();
	}
}
