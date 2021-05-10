package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.JurUser;

public interface JurUserMapperService {
	JurUser selectById(int userid);
	public void deleteById(int userid);
	public void insert(JurUser jurUser);
	public void update(JurUser jurUser);
	List<Map> selectByJur(int jurid);
}
