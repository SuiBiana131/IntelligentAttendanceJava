package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Overwork;
import com.example.demo.service.OverWorkMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Overwork")
public class OverworkController {
	@Autowired
    private OverWorkMapperService service;
	
	@RequestMapping("/selectOverworkAll")
	@ResponseBody
	public List<Integer> selectOverworkAll() {
		List<Integer> list=new java.util.ArrayList<>();
		Map<String,Object> map = new java.util.HashMap<>();
		map.put("userid", 1);map.put("start", "2021-03-14");map.put("end", "2021-03-20");map.put("str", "工作日");
		list.add(service.selectOverworkAll(map));list.add(service.selectOverworkType(map));map.put("str", "休息日");
		list.add(service.selectOverworkType(map));map.put("str", "节假日");list.add(service.selectOverworkType(map));
		map.put("str", "转调休");list.add(service.selectOverworkResType(map));
		map.put("str", "转加班费");list.add(service.selectOverworkResType(map));
		//System.out.print(de.getAddress());
        return list;
    }
	@RequestMapping("/select")
	@ResponseBody
	public Overwork selectOne() {
		Overwork de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Overwork> selectAll() {
		 List<Overwork> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Overwork information) {
		service.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		service.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(Overwork information) {
		service.update(information);;
		System.out.print("update");
    }
}
