package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class DesignMapperServiceImpl implements DesignMapperService{
	@Autowired
	DesignMapper designMapper;
	
	@Override
	public Design selectById(int id) {
		// TODO Auto-generated method stub
		return designMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		designMapper.deleteById(id);
	}

	@Override
	public void insert(Design design) {
		// TODO Auto-generated method stub
		designMapper.insert(design);
	}

	@Override
	public void update(Design design) {
		// TODO Auto-generated method stub
		designMapper.update(design);
	}
	@Override
	public List<Design> selectAll() {
		// TODO Auto-generated method stub
		return designMapper.selectAll();
	}

	@Override
	public List<Design> selectByOid(int oaId) {
		// TODO Auto-generated method stub
		return designMapper.selectByOid(oaId);
	}

	@Override
	public void deleteByOid(int oaId) {
		// TODO Auto-generated method stub
		designMapper.deleteByOid(oaId);
	}
}
