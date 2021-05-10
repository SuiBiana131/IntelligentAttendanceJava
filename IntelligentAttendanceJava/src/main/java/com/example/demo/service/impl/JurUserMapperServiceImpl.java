package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JurUser;
import com.example.demo.mapper.JurUserMapper;
import com.example.demo.service.JurUserMapperService;

@Service
public class JurUserMapperServiceImpl implements JurUserMapperService{
	@Autowired
	JurUserMapper jurUserMapper;
	@Override
	public JurUser selectById(int userid) {
		// TODO Auto-generated method stub
		return jurUserMapper.selectById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		jurUserMapper.deleteById(userid);
	}

	@Override
	public void insert(JurUser jurUser) {
		// TODO Auto-generated method stub
		jurUserMapper.insert(jurUser);
	}

	@Override
	public void update(JurUser jurUser) {
		// TODO Auto-generated method stub
		jurUserMapper.update(jurUser);
	}

	@Override
	public List<Map>  selectByJur(int jurid) {
		// TODO Auto-generated method stub
		return jurUserMapper.selectByJur(jurid);
	}

}
