package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Money;

public interface MoneyMapperService {
	Money selectById(int userid);
	public void deleteById(int userid);
	public void insert(Money money);
	public void update(Money money);
	Map selectMoney(int userid);
}
