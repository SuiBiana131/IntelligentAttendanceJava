package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class SheetMapperServiceImpl implements SheetMapperService{
	@Autowired
	SheetMapper sheetMapper;
	
	@Override
	public Sheet selectById(int id) {
		// TODO Auto-generated method stub
		return sheetMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sheetMapper.deleteById(id);
	}

	@Override
	public void insert(Sheet sheet) {
		// TODO Auto-generated method stub
		sheetMapper.insert(sheet);
	}

	@Override
	public void update(Sheet sheet) {
		// TODO Auto-generated method stub
		sheetMapper.update(sheet);
	}

	@Override
	public List<Sheet> selectAll() {
		// TODO Auto-generated method stub
		return sheetMapper.selectAll();
	}

	@Override
	public List<Sheet> selectAllByUse() {
		// TODO Auto-generated method stub
		return sheetMapper.selectAllByUse();
	}

	@Override
	public List<Sheet> selectAllByNotuse() {
		// TODO Auto-generated method stub
		return sheetMapper.selectAllByNotuse();
	}

}
