package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class CompetencegroupMapperServiceImpl implements CompetencegroupMapperService{
	@Autowired
	CompetencegroupMapper competencegroupMapper;
	@Override
	public Competencegroup selectById(int id) {
		// TODO Auto-generated method stub
		return competencegroupMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		competencegroupMapper.deleteById(id);
	}

	@Override
	public void insert(Competencegroup competencegroup) {
		// TODO Auto-generated method stub
		competencegroupMapper.insert(competencegroup);
	}

	@Override
	public void update(Competencegroup competencegroup) {
		// TODO Auto-generated method stub
		competencegroupMapper.update(competencegroup);
	}
	@Override
	public List<Competencegroup> selectAll() {
		// TODO Auto-generated method stub
		return competencegroupMapper.selectAll();
	}

	@Override
	public Competencegroup selectByname(String name) {
		// TODO Auto-generated method stub
		return competencegroupMapper.selectByname(name);
	}
}
