package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Design;
import com.example.demo.entity.UserAccommodation;
import com.example.demo.entity.Usergroup;
import com.example.demo.service.*;

@CrossOrigin
@Controller
@RequestMapping("/Usergroup")
public class UsergroupController {
	@Autowired
    private UsergroupMapperService service;
	
	@RequestMapping("/select")
	@ResponseBody
	public Usergroup selectById() {
		Usergroup de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectNum")
	@ResponseBody
	public List<String> selectNum() {
		List<String> de= service.selectNum();
		System.out.print(de.size());
        return de;
    }
	@RequestMapping("/selectByGroupname")
	@ResponseBody
	public List<Map<String, Object>> selectByGroupname() {
		
		List<Map<String, Object>> lists=new java.util.ArrayList<>();
		List<String> names= service.selectNum();
		Map<String, Object> map;
		for(int i=0;i<names.size();i++)
		{
			map=new java.util.HashMap<>();
			map.put("name", names.get(i));
			map.put("isOpen", true);
			map.put("Usergroup", service.selectByGroupname(names.get(i)));
			lists.add(map);
		}	
		System.out.print(lists.size());
        return lists;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Usergroup information) {
		service.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteById() {
		service.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestBody List<Usergroup> usergroups) {
		for(int i=0;i<usergroups.size();i++)
			service.update(usergroups.get(i));
		System.out.print("update");
    }
}
