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
@RequestMapping("/Formcontent")
public class FormcontentController {
	@Autowired
	private FormcontentMapperService Formcontent;
	@Autowired
	private FormapplyMapperService Formapply;
	
	@RequestMapping("/select")
	@ResponseBody
	public Formcontent selectOne() {
		Formcontent de= Formcontent.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectByOid")
	@ResponseBody
	public List<Formcontent> selectByOid(int formid) {
		 List<Formcontent> de= Formcontent.selectByOid(formid);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Formcontent> selectAll() {
		 List<Formcontent> de= Formcontent.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(@RequestBody List<Formcontent> informations) {
		for(int i=0;i<informations.size();i++)
			Formcontent.insert(informations.get(i));
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		Formcontent.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(Formcontent information) {
		Formcontent.update(information);;
		System.out.print("update");
    }
	
}
