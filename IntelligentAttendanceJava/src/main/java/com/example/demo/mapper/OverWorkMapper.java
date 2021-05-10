package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.*;

public interface OverWorkMapper {
	Overwork selectById(int id);
	public void deleteById(int id);
	public void insert(Overwork Overwork);
	public void update(Overwork Overwork);
	List<Overwork> selectAll();
	public int selectOverworkType(Map map);
	public int selectOverworkResType(Map map);
	public int selectOverworkAll(Map map);
}
