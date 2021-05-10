package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface OadesignerMapper {
	Oadesigner selectById(int id);
	public void deleteById(int id);
	public void insert(Oadesigner oadesigner);
	public void update(Oadesigner oadesigner);
}
