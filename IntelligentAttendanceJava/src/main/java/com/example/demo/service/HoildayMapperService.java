package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface HoildayMapperService {
	Hoilday selectById(int id);
	public void deleteById(int id);
	public void insert(Hoilday hoilday);
	public void update(Hoilday hoilday);
	List<Hoilday> selectAll();
}
