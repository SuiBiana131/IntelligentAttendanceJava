package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyMoney;
import com.example.demo.mapper.MyMoneyMapper;
import com.example.demo.service.MyMoneyMapperService;

@Service
public class MyMoneyMapperServiceImpl implements MyMoneyMapperService{
	@Autowired
	MyMoneyMapper myMoneyMapper;
	@Override
	public MyMoney selectById(int userid) {
		// TODO Auto-generated method stub
		return myMoneyMapper.selectById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		myMoneyMapper.deleteById(userid);
	}

	@Override
	public void insert(MyMoney myMoney) {
		// TODO Auto-generated method stub
		myMoneyMapper.insert(myMoney);
	}

	@Override
	public void update(MyMoney myMoney) {
		// TODO Auto-generated method stub
		myMoneyMapper.update(myMoney);
	}

	@Override
	public Map<String, Long> selectCount(int userid) {
		// TODO Auto-generated method stub
		return myMoneyMapper.selectCount(userid);
	}

	@Override
	public List<MyMoney> selectAll() {
		// TODO Auto-generated method stub
		return myMoneyMapper.selectAll();
	}

	@Override
	public List<MyMoney> selectCondition(Map map) {
		// TODO Auto-generated method stub
		return myMoneyMapper.selectCondition(map);
	}

}
