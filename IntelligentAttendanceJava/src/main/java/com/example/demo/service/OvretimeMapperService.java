package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface OvretimeMapperService {
	Ovretime selectById(int id);
	public void deleteById(int id);
	public void insert(Ovretime ovretime);
	public void update(Ovretime ovretime);
	List<Ovretime> selectAll();
}
