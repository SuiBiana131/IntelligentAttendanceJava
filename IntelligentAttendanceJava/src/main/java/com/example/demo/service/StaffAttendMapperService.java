package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.StaffAttend;

public interface StaffAttendMapperService {
	StaffAttend selectById(int id);
	public void deleteById(int id);
	public void insert(StaffAttend accommodation);
	public void update(StaffAttend accommodation);
	List<StaffAttend> selectAll();
	List<Map<String,Object>> selectBydate(String str);
	List<StaffAttend> selectCondition(Map map);
	StaffAttend selectAttend(StaffAttend accommodation);
	public int selectAttnum(Map map);
	public int selectNum(Map map);
	public int selectWorkTime(Map map);
	public int selectLateTime(Map map);
	public int selectLeaveTime(Map map);
	List<Map<String,Object>> selectByEveryday(Map map);
}
