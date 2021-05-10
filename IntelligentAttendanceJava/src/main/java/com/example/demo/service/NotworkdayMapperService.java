package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface NotworkdayMapperService {
	Notworkday selectById(int id);
	public void deleteById(int id);
	public void insert(Notworkday notworkday);
	public void update(Notworkday notworkday);
	List<Notworkday> selectAll();
	List<Notworkday> selectBygid(int id);
}
