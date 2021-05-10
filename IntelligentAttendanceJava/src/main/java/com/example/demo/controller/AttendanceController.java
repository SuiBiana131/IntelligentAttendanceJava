package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.Attendance;
import com.example.demo.service.AccommodationMapperService;
import com.example.demo.service.AttendanceMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Attendance")
public class AttendanceController {
	@Autowired
    private AttendanceMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return "Accommodation";
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
	public Attendance selectOne() {
		Attendance de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Attendance information) {
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
	public void update(Attendance information) {
		service.update(information);;
		System.out.print("update");
    }
}
