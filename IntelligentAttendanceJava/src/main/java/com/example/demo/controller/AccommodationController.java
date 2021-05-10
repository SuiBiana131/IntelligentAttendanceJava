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

import com.example.demo.entity.Accommodation;
import com.example.demo.entity.Information;
import com.example.demo.service.AccommodationMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Accommodation")
public class AccommodationController {
	@Autowired
    private AccommodationMapperService service;
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
	public Accommodation selectOne() {
		Accommodation de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Accommodation> selectAll() {
		 List<Accommodation> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectCondition")
	@ResponseBody
	public List<Accommodation> selectCondition(@RequestParam Map<String,Object> map) {
		System.out.println(map.get("name"));
		
		List<Accommodation> de= service.selectCondition(map);
		
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Accommodation information) {
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
	public void update(Accommodation information) {
		service.update(information);;
		System.out.print("update");
    }
}
