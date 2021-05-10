package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("/Formapply")
public class FormapplyController {
	@Autowired
	private FormcontentMapperService Formcontent;
	@Autowired
	private FormapplyMapperService Formapply;
	@Autowired
    private UserMapperService userService;
	
	@RequestMapping("/select")
	@ResponseBody
	public Formapply selectOne() {
		Formapply de= Formapply.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Formapply> selectAll() {
		 List<Formapply> de= Formapply.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAllOk")
	@ResponseBody
	public List<Formapply> selectAllOk() {
		 List<Formapply> de= Formapply.selectAllOk();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAllNo")
	@ResponseBody
	public List<Formapply> selectAllNo() {
		 List<Formapply> de= Formapply.selectAllNo();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAlldelete")
	@ResponseBody
	public List<Formapply> selectAlldelete(String username) {
		 List<Formapply> de= Formapply.selectAlldelete(username);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Formapply information) {
		User user = userService.selectByName(information.getUsername());
		information.userid = user.getId();
		Formapply.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		Formapply.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(Formapply information) {
		System.out.print(information.status);
		Formapply.update(information);;
		System.out.print("update");
    }
}
