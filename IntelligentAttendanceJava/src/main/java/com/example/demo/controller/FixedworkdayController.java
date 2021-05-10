package com.example.demo.controller;
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
@RequestMapping("/Fixedworkday")
public class FixedworkdayController {
	@Autowired
    private AccommodationMapperService service;
	@Autowired
	private ClassmanageMapperService classmanage;
	@Autowired
	private CompetencegroupMapperService Competencegroup;
	@Autowired
	private FixedworkdayMapperService Fixedworkday;
	@Autowired
	private HoildayMapperService Hoilday;
	@Autowired
	private MappointMapperService Mappoint;
	@Autowired
	private MustworkdayMapperService Mustworkday;
	@Autowired
	private NotworkdayMapperService Notworkday;
	@Autowired
	private OvretimeMapperService Ovretime;
	@Autowired
	private DesignMapperService Design;
	@Autowired
	private OadesignerMapperService Oadesigner;
	
	@RequestMapping("/select")
	@ResponseBody
	public Fixedworkday selectOne() {
		Fixedworkday de= Fixedworkday.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectBygid")
	@ResponseBody
	public List<Fixedworkday> selectBygid(@RequestParam(value= "id") int id) {
		 List<Fixedworkday> de= Fixedworkday.selectBygid(id);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Fixedworkday> selectAll() {
		 List<Fixedworkday> de= Fixedworkday.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Fixedworkday fixedworkday) {
		Fixedworkday.insert(fixedworkday);
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
	public void update(@RequestBody List<Fixedworkday> informations) {
		for(int i=0;i<informations.size();i++) {
			System.out.print(informations.get(i).groupId);
			if(informations.get(i).id!=0)
				Fixedworkday.update(informations.get(i));
			else
				Fixedworkday.insert(informations.get(i));
		}
    }
}
