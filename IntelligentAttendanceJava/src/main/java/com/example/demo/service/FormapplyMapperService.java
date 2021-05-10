package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.*;
public interface FormapplyMapperService {
	Formapply selectById(int id);
	public void deleteById(int id);
	public void insert(Formapply formapply);
	public void update(Formapply formapply);
	List<Formapply> selectAll();
	List<Formapply> selectAllOk();
	List<Formapply> selectAllNo();
	List<Formapply> selectAlldelete(String username);
}
