package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.MyMoney;

public interface AccommodationMapperService {
	Accommodation selectById(int id);
	public void deleteById(int id);
	public void insert(Accommodation accommodation);
	public void update(Accommodation accommodation);
	List<Accommodation> selectAll();
	List<Accommodation> selectCondition(Map map);
}
