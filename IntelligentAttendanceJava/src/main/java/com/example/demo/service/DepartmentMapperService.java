package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Department;

public interface DepartmentMapperService {

	Department selectOne(int id);
	public void deleteDepartment(int id);
	public void updateDepartment(Department department);
	public List<Department> selectDepartmentAll();
	
	public List<Department> selectDepartmentPage(int start,int pageNum);
}
