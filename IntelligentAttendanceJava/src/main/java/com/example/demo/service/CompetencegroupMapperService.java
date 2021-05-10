package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface CompetencegroupMapperService {
	Competencegroup selectById(int id);
	public void deleteById(int id);
	public void insert(Competencegroup competencegroup);
	public void update(Competencegroup competencegroup);
	List<Competencegroup> selectAll();
	Competencegroup selectByname(String name);
}
