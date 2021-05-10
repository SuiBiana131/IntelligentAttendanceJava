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
@RequestMapping("/Notworkday")
public class NotworkdayController {
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
	public Notworkday selectOne() {
		Notworkday de= Notworkday.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectBygid")
	@ResponseBody
	public List<Notworkday> selectBygid(@RequestParam(value= "id")  int id) {
		 List<Notworkday> de= Notworkday.selectBygid(id);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Notworkday> selectAll() {
		 List<Notworkday> de= Notworkday.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Notworkday information) {
		Notworkday.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		Notworkday.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestBody List<Notworkday> informations) {
		Map<Integer,Notworkday> map= new HashMap<>();
		List<Notworkday> old= Notworkday.selectBygid(informations.get(0).groupId);
		for(int i=0;i<informations.size();i++) {
			if(informations.get(i).id==0)
				Notworkday.insert(informations.get(i));
			else
				map.put(informations.get(i).id, informations.get(i));
		}
		for(int i=0;i<old.size();i++) {
			if(map.containsKey(old.get(i).id))
				Notworkday.update(map.get(old.get(i).id));
			else
				Notworkday.deleteById(old.get(i).id);
		}
    }
}
