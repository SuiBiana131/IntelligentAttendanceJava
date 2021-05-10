package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class OvretimeMapperServiceImpl implements OvretimeMapperService{
	@Autowired
	OvretimeMapper ovretimeMapper;
	@Override
	public Ovretime selectById(int id) {
		// TODO Auto-generated method stub
		return ovretimeMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ovretimeMapper.deleteById(id);
	}

	@Override
	public void insert(Ovretime ovretime) {
		// TODO Auto-generated method stub
		ovretimeMapper.insert(ovretime);
	}

	@Override
	public void update(Ovretime ovretime) {
		// TODO Auto-generated method stub
		ovretimeMapper.update(ovretime);
	}
	@Override
	public List<Ovretime> selectAll() {
		// TODO Auto-generated method stub
		return ovretimeMapper.selectAll();
	}
}
