package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class FormcontentMapperServiceImpl implements FormcontentMapperService{
	@Autowired
	FormcontentMapper formcontentMapper;
	
	@Override
	public Formcontent selectById(int id) {
		// TODO Auto-generated method stub
		return formcontentMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		formcontentMapper.deleteById(id);
	}

	@Override
	public void insert(Formcontent formcontent) {
		// TODO Auto-generated method stub
		formcontentMapper.insert(formcontent);
	}

	@Override
	public void update(Formcontent formcontent) {
		// TODO Auto-generated method stub
		formcontentMapper.update(formcontent);
	}

	@Override
	public List<Formcontent> selectAll() {
		// TODO Auto-generated method stub
		return formcontentMapper.selectAll();
	}

	@Override
	public List<Formcontent> selectByOid(int formid) {
		// TODO Auto-generated method stub
		return formcontentMapper.selectByOid(formid);
	}

}
