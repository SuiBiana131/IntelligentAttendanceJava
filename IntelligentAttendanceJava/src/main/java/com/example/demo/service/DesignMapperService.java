package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.Design;

public interface DesignMapperService {
	Design selectById(int id);
	public void deleteById(int id);
	public void deleteByOid(int oaId);
	public void insert(Design design);
	public void update(Design design);
	List<Design> selectAll();
	List<Design> selectByOid(int oaId);
}
