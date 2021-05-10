package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Jur;

public interface JurMapper {
	Jur selectById(int id);
	public void deleteById(int id);
	public void insert(Jur jur);
	public void update(Jur jur);
	List<Jur> selectAll();
}
