package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.mapper.AccommodationMapper;
import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.service.AccommodationMapperService;
import com.example.demo.service.AttendanceMapperService;
@Service
public class AttendanceMapperServiceImpl implements AttendanceMapperService{
	@Autowired
	AttendanceMapper attendanceMapper;
	@Override
	public Attendance selectById(int id) {
		// TODO Auto-generated method stub
		return attendanceMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		attendanceMapper.deleteById(id);
	}

	@Override
	public void insert(Attendance accommodation) {
		// TODO Auto-generated method stub
		attendanceMapper.insert(accommodation);
	}

	@Override
	public void update(Attendance accommodation) {
		// TODO Auto-generated method stub
		attendanceMapper.update(accommodation);
	}

}
