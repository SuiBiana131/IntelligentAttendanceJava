package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.JurUser;

public interface JurUserMapper {
	JurUser selectById(int userid);
	public void deleteById(int userid);
	public void insert(JurUser jurUser);
	public void update(JurUser jurUser);
	List<Map> selectByJur(int jurid);
}
