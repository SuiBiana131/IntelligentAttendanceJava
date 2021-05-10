package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccommodation;
import com.example.demo.mapper.UserAccommodationMapper;
import com.example.demo.service.UserAccommodationMapperService;

@Service
public class UserAccommodationMapperServiceImpl implements UserAccommodationMapperService{
	@Autowired
	UserAccommodationMapper userAccommodationMapper;
	@Override
	public UserAccommodation selectById(int userid) {
		// TODO Auto-generated method stub
		return userAccommodationMapper.selectById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		userAccommodationMapper.deleteById(userid);
	}

	@Override
	public void insert(UserAccommodation userAccommodation) {
		// TODO Auto-generated method stub
		userAccommodationMapper.insert(userAccommodation);
	}

	@Override
	public void update(UserAccommodation userAccommodation) {
		// TODO Auto-generated method stub
		userAccommodationMapper.update(userAccommodation);
	}

	@Override
	public List<Map> selectAccommodation(int id) {
		// TODO Auto-generated method stub
		return userAccommodationMapper.selectAccommodation(id);
	}

}
