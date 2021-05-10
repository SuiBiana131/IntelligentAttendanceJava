package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface MappointMapperService {
	Mappoint selectById(int id);
	public void deleteById(int id);
	public void insert(Mappoint mappoint);
	public void update(Mappoint mappoint);
	List<Mappoint> selectAll();
	List<Mappoint> selectBygid(int id);
}
