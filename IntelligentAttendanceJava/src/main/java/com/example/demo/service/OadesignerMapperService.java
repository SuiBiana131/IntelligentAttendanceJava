package com.example.demo.service;

import com.example.demo.entity.Oadesigner;

public interface OadesignerMapperService {
	Oadesigner selectById(int id);
	public void deleteById(int id);
	public void insert(Oadesigner oadesigner);
	public void update(Oadesigner oadesigner);
}
