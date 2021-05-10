package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.MyMoney;
import com.example.demo.mapper.AccommodationMapper;
import com.example.demo.service.AccommodationMapperService;

@Service
public class AccommodationMapperServiceImpl implements AccommodationMapperService{
	@Autowired
	AccommodationMapper accommodationMapper;
	
	@Override
	public Accommodation selectById(int id) {
		// TODO Auto-generated method stub
		Accommodation accommodation= accommodationMapper.selectById(id);
		return accommodation;
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		accommodationMapper.deleteById(userid);
	}

	@Override
	public void insert(Accommodation accommodation) {
		// TODO Auto-generated method stub
		accommodationMapper.insert(accommodation);
	}

	@Override
	public void update(Accommodation accommodation) {
		// TODO Auto-generated method stub
		accommodationMapper.update(accommodation);
	}

	@Override
	public List<Accommodation> selectAll() {
		// TODO Auto-generated method stub
		return accommodationMapper.selectAll();
	}

	@Override
	public List<Accommodation> selectCondition(Map map) {
		// TODO Auto-generated method stub
		return accommodationMapper.selectCondition(map);
	}
}
