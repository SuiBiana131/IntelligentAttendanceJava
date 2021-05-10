package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Money;
import com.example.demo.mapper.MoneyMapper;
import com.example.demo.service.MoneyMapperService;

@Service
public class MoneyMapperServiceImpl implements MoneyMapperService{
	@Autowired
	MoneyMapper moneyMapper;
	@Override
	public Money selectById(int userid) {
		// TODO Auto-generated method stub
		return moneyMapper.selectById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		moneyMapper.deleteById(userid);
	}

	@Override
	public void insert(Money money) {
		// TODO Auto-generated method stub
		moneyMapper.insert(money);
	}

	@Override
	public void update(Money money) {
		// TODO Auto-generated method stub
		moneyMapper.update(money);
	}

	@Override
	public Map selectMoney(int userid) {
		// TODO Auto-generated method stub
		return moneyMapper.selectMoney(userid);
	}

}
