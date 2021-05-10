package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jur;
import com.example.demo.mapper.JurMapper;
import com.example.demo.service.JurMapperService;

@Service
public class JurMapperServiceImpl implements JurMapperService{
	@Autowired
	JurMapper jurMapper;
	
	@Override
	public Jur selectById(int id) {
		// TODO Auto-generated method stub
		return jurMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		jurMapper.deleteById(id);
	}

	@Override
	public void insert(Jur jur) {
		// TODO Auto-generated method stub
		jurMapper.insert(jur);
	}

	@Override
	public void update(Jur jur) {
		// TODO Auto-generated method stub
		jurMapper.update(jur);
	}

	@Override
	public List<Jur> selectAll() {
		// TODO Auto-generated method stub
		return jurMapper.selectAll();
	}

}
