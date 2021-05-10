package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("/Group")
public class GroupController {
	@Autowired
    private GroupMapperService service;
	@Autowired
    private UsergroupMapperService usergroup;
	
	@RequestMapping("/select")
	@ResponseBody
	public Group selectOne(String name) {
		Group de= service.selectById(name);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Group> selectAll() {
		 Group group=new Group();
		 List<String> list = usergroup.selectNum();
		 for(int i=0;i<list.size();i++) {
			 group.setName(list.get(i));
			 if(service.selectById(list.get(i))==null)
				 service.insert(group);
		 } 
		 List<Group> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Group information) {
		service.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(String name) {
		service.deleteById(name);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestBody List<Group> informations) {
		for(int i=0;i<informations.size();i++)
			service.update(informations.get(i));;
		System.out.print("update");
    }
}
