package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface FixedworkdayMapperService {
	Fixedworkday selectById(int id);
	public void deleteById(int id);
	public void insert(Fixedworkday fixedworkday);
	public void update(Fixedworkday fixedworkday);
	List<Fixedworkday> selectAll();
	List<Fixedworkday> selectBygid(int id);
}
