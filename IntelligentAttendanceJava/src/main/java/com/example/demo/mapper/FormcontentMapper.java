package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface FormcontentMapper {
	Formcontent selectById(int id);
	public void deleteById(int id);
	public void insert(Formcontent formcontent);
	public void update(Formcontent formcontent);
	List<Formcontent> selectAll();
	List<Formcontent> selectByOid(int formid);
}
