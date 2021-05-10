package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface NotworkdayMapper {
	Notworkday selectById(int id);
	public void deleteById(int id);
	public void insert(Notworkday notworkday);
	public void update(Notworkday notworkday);
	List<Notworkday> selectAll();
	List<Notworkday> selectBygid(int id);
}
