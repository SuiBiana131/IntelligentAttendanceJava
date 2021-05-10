package com.example.demo.mapper;

import java.util.List;
//import java.util.Map;
import java.util.Map;

import com.example.demo.entity.Information;
import com.example.demo.entity.StaffAttend;

public interface InformationMapper {
	Information selectById(int userid);
	public void deleteById(int userid);
	public void insert(Information information);
	public void update(Information information);
	Information selectName(String username);
	List<Information> selectAll();
	List<Information> selectCondition(Map map);
	
	//public List<Information> selectDepartmentAll();
	
	//public List<Information> selectDepartmentPage(Map map);
}
