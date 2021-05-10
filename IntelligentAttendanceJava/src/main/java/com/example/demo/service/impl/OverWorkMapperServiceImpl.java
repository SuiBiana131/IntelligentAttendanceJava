package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Overwork;
import com.example.demo.mapper.OverWorkMapper;
import com.example.demo.service.OverWorkMapperService;

@Service
public class OverWorkMapperServiceImpl implements OverWorkMapperService{
	@Autowired
	OverWorkMapper overWorkMapper;

	@Override
	public Overwork selectById(int id) {
		// TODO Auto-generated method stub
		return overWorkMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		overWorkMapper.deleteById(id);
	}

	@Override
	public void insert(Overwork Overwork) {
		// TODO Auto-generated method stub
		overWorkMapper.insert(Overwork);
	}

	@Override
	public void update(Overwork Overwork) {
		// TODO Auto-generated method stub
		overWorkMapper.update(Overwork);
	}

	@Override
	public List<Overwork> selectAll() {
		// TODO Auto-generated method stub
		return overWorkMapper.selectAll();
	}

	@Override
	public int selectOverworkType(Map map) {
		// TODO Auto-generated method stub
		return overWorkMapper.selectOverworkType(map);
	}

	@Override
	public int selectOverworkResType(Map map) {
		// TODO Auto-generated method stub
		return overWorkMapper.selectOverworkResType(map);
	}

	@Override
	public int selectOverworkAll(Map map) {
		// TODO Auto-generated method stub
		return overWorkMapper.selectOverworkAll(map);
	}
}
