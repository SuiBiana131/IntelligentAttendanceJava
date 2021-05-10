package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.UserAccommodation;

public interface UserAccommodationMapperService {
	UserAccommodation selectById(int userid);
	public void deleteById(int userid);
	public void insert(UserAccommodation userAccommodation);
	public void update(UserAccommodation userAccommodation);
	List<Map> selectAccommodation(int id);
}
