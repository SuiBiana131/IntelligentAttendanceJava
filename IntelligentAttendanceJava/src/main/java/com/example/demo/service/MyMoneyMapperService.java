package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.MyMoney;

public interface MyMoneyMapperService {
	MyMoney selectById(int userid);
	public void deleteById(int userid);
	public void insert(MyMoney myMoney);
	public void update(MyMoney myMoney);
	Map<String,Long> selectCount(int userid);
	List<MyMoney> selectAll();
	List<MyMoney> selectCondition(Map map);
}
