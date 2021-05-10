package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Jur;

public interface JurMapperService {
	Jur selectById(int id);
	public void deleteById(int id);
	public void insert(Jur jur);
	public void update(Jur jur);
	List<Jur> selectAll();
}
