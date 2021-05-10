package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface FormcontentMapperService {
	Formcontent selectById(int id);
	public void deleteById(int id);
	public void insert(Formcontent formcontent);
	public void update(Formcontent formcontent);
	List<Formcontent> selectAll();
	List<Formcontent> selectByOid(int formid);
}
