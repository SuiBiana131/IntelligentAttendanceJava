package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StaffAttend;
import com.example.demo.mapper.AccommodationMapper;
import com.example.demo.mapper.StaffAttendMapper;
import com.example.demo.service.StaffAttendMapperService;
@Service
public class StaffAttendMapperServiceImpl implements StaffAttendMapperService{
	@Autowired
	StaffAttendMapper staffAttendMapper;
	@Override
	public StaffAttend selectById(int id) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		staffAttendMapper.deleteById(id);
	}

	@Override
	public void insert(StaffAttend accommodation) {
		// TODO Auto-generated method stub
		staffAttendMapper.insert(accommodation);
	}

	@Override
	public void update(StaffAttend accommodation) {
		// TODO Auto-generated method stub
		staffAttendMapper.update(accommodation);
	}

	@Override
	public List<StaffAttend> selectAll() {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectAll();
	}

	@Override
	public List<StaffAttend> selectCondition(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectCondition(map);
	}

	@Override
	public StaffAttend selectAttend(StaffAttend accommodation) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectAttend(accommodation);
	}

	@Override
	public int selectAttnum(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectAttnum(map);
	}

	@Override
	public int selectNum(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectNum(map);
	}

	@Override
	public int selectWorkTime(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectWorkTime(map);
	}

	@Override
	public int selectLateTime(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectLateTime(map);
	}

	@Override
	public int selectLeaveTime(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectLeaveTime(map);
	}

	@Override
	public List<Map<String,Object>> selectBydate(String str) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectBydate(str);
	}

	@Override
	public List<Map<String, Object>> selectByEveryday(Map map) {
		// TODO Auto-generated method stub
		return staffAttendMapper.selectByEveryday(map);
	}

}
