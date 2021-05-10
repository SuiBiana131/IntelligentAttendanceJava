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

import com.example.demo.entity.JurUser;
import com.example.demo.service.JurUserMapperService;

@Controller
@CrossOrigin
@RequestMapping("/JurUser")
public class JurUserController {
	@Autowired
    private JurUserMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return "hello";
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
	public JurUser selectOne() {
		JurUser de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectByJur")
	@ResponseBody
	public List<Map> selectByJur(@RequestParam int userid) {
		//System.out.println(userid);
		//System.out.println("sdad");
		JurUser de= service.selectById(userid);
		List<Map> jur= service.selectByJur(de.getJurid());
		
        return jur;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(JurUser information) {
		service.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		service.deleteById(2);
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(JurUser information) {
		service.update(information);
		System.out.print("update");
    }
}
