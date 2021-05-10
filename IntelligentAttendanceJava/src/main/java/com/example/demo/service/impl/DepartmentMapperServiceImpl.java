package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentMapperService;

@Service
public class DepartmentMapperServiceImpl implements DepartmentMapperService{
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public Department selectOne(int id) {
		// TODO Auto-generated method stub
		Department department= departmentMapper.selectOneById(id);
		return department;
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentMapper.deleteDepartment(id);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.updateDepartment(department);
	}

	@Override
	public List<Department> selectDepartmentAll() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentMapper.selectDepartmentAll();
		return departments;
	}

	@Override
	public List<Department> selectDepartmentPage(int start,int pageNum) {
		// TODO Auto-generated method stub
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 map.put("start",start);
		 map.put("pageNum",pageNum);
		List<Department> departments = departmentMapper.selectDepartmentPage(map);
		return departments;
	}

}
