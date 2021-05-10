package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.*;

@Service
public class OadesignerMapperServiceImpl implements OadesignerMapperService{
	@Autowired
	OadesignerMapper oadesignerMapper;
	
	@Override
	public Oadesigner selectById(int id) {
		// TODO Auto-generated method stub
		return oadesignerMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		oadesignerMapper.deleteById(id);
	}

	@Override
	public void insert(Oadesigner oadesigner) {
		// TODO Auto-generated method stub
		oadesignerMapper.insert(oadesigner);
	}

	@Override
	public void update(Oadesigner oadesigner) {
		// TODO Auto-generated method stub
		oadesignerMapper.update(oadesigner);
	}

}
