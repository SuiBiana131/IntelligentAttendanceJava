package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface OvretimeMapper {
	Ovretime selectById(int id);
	public void deleteById(int id);
	public void insert(Ovretime ovretime);
	public void update(Ovretime ovretime);
	List<Ovretime> selectAll();
}
