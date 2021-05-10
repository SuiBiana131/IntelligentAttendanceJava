package com.example.demo.service;

import com.example.demo.entity.Attendance;

public interface AttendanceMapperService {
	Attendance selectById(int id);
	public void deleteById(int id);
	public void insert(Attendance accommodation);
	public void update(Attendance accommodation);
}
