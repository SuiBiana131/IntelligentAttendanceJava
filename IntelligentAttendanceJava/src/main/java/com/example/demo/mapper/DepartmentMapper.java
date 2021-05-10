package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Department;

public interface DepartmentMapper {

	Department selectOneById(int id);
	public void deleteDepartment(int id);
	public void updateDepartment(Department department);
	public List<Department> selectDepartmentAll();
	
	public List<Department> selectDepartmentPage(Map map);
}
