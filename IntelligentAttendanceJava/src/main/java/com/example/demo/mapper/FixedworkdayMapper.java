package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface FixedworkdayMapper {
	Fixedworkday selectById(int id);
	public void deleteById(int id);
	public void insert(Fixedworkday fixedworkday);
	public void update(Fixedworkday fixedworkday);
	List<Fixedworkday> selectAll();
	List<Fixedworkday> selectBygid(int id);
}
