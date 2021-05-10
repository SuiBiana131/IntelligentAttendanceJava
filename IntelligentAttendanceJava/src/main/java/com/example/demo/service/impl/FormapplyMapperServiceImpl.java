package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class FormapplyMapperServiceImpl implements FormapplyMapperService{
	@Autowired
	FormapplyMapper formapplyMapper;
	
	@Override
	public Formapply selectById(int id) {
		// TODO Auto-generated method stub
		return formapplyMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		formapplyMapper.deleteById(id);
	}

	@Override
	public void insert(Formapply formapply) {
		// TODO Auto-generated method stub
		formapplyMapper.insert(formapply);
	}

	@Override
	public void update(Formapply formapply) {
		// TODO Auto-generated method stub
		formapplyMapper.update(formapply);
	}

	@Override
	public List<Formapply> selectAll() {
		// TODO Auto-generated method stub
		return formapplyMapper.selectAll();
	}

	@Override
	public List<Formapply> selectAllOk() {
		// TODO Auto-generated method stub
		return formapplyMapper.selectAllOk();
	}

	@Override
	public List<Formapply> selectAllNo() {
		// TODO Auto-generated method stub
		return formapplyMapper.selectAllNo();
	}

	@Override
	public List<Formapply> selectAlldelete(String username) {
		// TODO Auto-generated method stub
		return formapplyMapper.selectAlldelete(username);
	}

}
