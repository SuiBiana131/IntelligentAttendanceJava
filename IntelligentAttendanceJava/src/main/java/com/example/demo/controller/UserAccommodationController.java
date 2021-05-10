package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.UserAccommodation;
import com.example.demo.service.UserAccommodationMapperService;

@CrossOrigin
@Controller
@RequestMapping("/UserAccommodation")
public class UserAccommodationController {
	@Autowired
    private UserAccommodationMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return "UserAccommodation";
    }
	
	/**@RequestMapping("/select")
	@ResponseBody
	public String selectOne() {
		Department de= service.selectOne(2);
		System.out.print(de.getDepartmentName());
        return "hello";
    }**/
	
	@RequestMapping("/select")
	@ResponseBody
	public UserAccommodation selectOne() {
		UserAccommodation de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAccommodation")
	@ResponseBody
	public List<Map> selectAccommodation(@RequestParam int id) {
		List<Map> de= service.selectAccommodation(id);
		System.out.print(de.size());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(UserAccommodation information) {
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
	public void update(UserAccommodation information) {
		service.update(information);;
		System.out.print("update");
    }
}
