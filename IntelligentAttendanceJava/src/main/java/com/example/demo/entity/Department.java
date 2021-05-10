package com.example.demo.entity;

public class Department {
	int id;
	String departmentName;
	String departmentDescribe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescrible() {
		return departmentDescribe;
	}
	public void setDepartmentDescrible(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}
	public Department(int id, String departmentName, String departmentDescribe) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescribe = departmentDescribe;
	}
	public Department() {
		super();
	}
}
