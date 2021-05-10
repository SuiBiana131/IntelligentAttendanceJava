package com.example.demo.mapper;

import com.example.demo.entity.Attendance;

public interface AttendanceMapper {
	Attendance selectById(int id);
	public void deleteById(int id);
	public void insert(Attendance accommodation);
	public void update(Attendance accommodation);
}
