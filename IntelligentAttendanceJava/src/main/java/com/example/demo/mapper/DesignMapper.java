package com.example.demo.mapper;
import java.util.List;

import com.example.demo.entity.*;
public interface DesignMapper {
	Design selectById(int id);
	public void deleteById(int id);
	public void deleteByOid(int oaId);
	public void insert(Design design);
	public void update(Design design);
	List<Design> selectAll();
	List<Design> selectByOid(int oaId);
}
