package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.MyMoney;

public interface AccommodationMapper {
	Accommodation selectById(int id);
	public void deleteById(int id);
	public void insert(Accommodation accommodation);
	public void update(Accommodation accommodation);
	List<Accommodation> selectAll();
	List<Accommodation> selectCondition(Map map);
}
