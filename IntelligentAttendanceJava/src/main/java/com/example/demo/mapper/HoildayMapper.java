package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface HoildayMapper {
	Hoilday selectById(int id);
	public void deleteById(int id);
	public void insert(Hoilday hoilday);
	public void update(Hoilday hoilday);
	List<Hoilday> selectAll();
}
