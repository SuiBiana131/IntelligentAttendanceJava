package com.example.demo.service;

import com.example.demo.entity.Information;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface InformationMapperService {
	Information selectById(int userid);
	public void deleteById(int userid);
	public void insert(Information information);
	public void update(Information information);
	Information selectName(String username);
	List<Information> selectAll();
	List<Information> selectCondition(Map map);
}
