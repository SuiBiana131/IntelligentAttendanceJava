package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Jur;
import com.example.demo.service.JurMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Jur")
public class JurController {
	@Autowired
    private JurMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return "Jur";
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
	public Jur selectOne() {
		Jur de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Jur> selectAll() {
		List<Jur> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Jur information) {
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
	public void update(Jur information) {
		service.update(information);;
		System.out.print("update");
    }
}
