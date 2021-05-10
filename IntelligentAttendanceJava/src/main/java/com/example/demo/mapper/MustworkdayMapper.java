package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface MustworkdayMapper {
	Mustworkday selectById(int id);
	public void deleteById(int id);
	public void insert(Mustworkday mustworkday);
	public void update(Mustworkday mustworkday);
	List<Mustworkday> selectAll();
	List<Mustworkday> selectBygid(int id);
}
