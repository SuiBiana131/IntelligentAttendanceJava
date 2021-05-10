package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Money;

public interface MoneyMapper {
	Money selectById(int userid);
	public void deleteById(int userid);
	public void insert(Money money);
	public void update(Money money);
	Map selectMoney(int userid);
}
