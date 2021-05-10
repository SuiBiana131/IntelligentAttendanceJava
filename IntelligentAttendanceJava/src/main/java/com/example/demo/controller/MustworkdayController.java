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
@RequestMapping("/Mustworkday")
public class MustworkdayController {
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
	public Mustworkday selectOne() {
		Mustworkday de= Mustworkday.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectBygid")
	@ResponseBody
	public List<Mustworkday> selectBygid(@RequestParam(value= "id")  int id) {
		 List<Mustworkday> de= Mustworkday.selectBygid(id);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Mustworkday> selectAll() {
		 List<Mustworkday> de= Mustworkday.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Mustworkday information) {
		Mustworkday.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		Mustworkday.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestBody List<Mustworkday> informations) {
		Map<Integer,Mustworkday> map= new HashMap<>();
		List<Mustworkday> old= Mustworkday.selectBygid(informations.get(0).groupId);
		for(int i=0;i<informations.size();i++) {
			if(informations.get(i).id==0)
				Mustworkday.insert(informations.get(i));
			else
				map.put(informations.get(i).id, informations.get(i));
		}
		for(int i=0;i<old.size();i++) {
			if(map.containsKey(old.get(i).id))
				Mustworkday.update(map.get(old.get(i).id));
			else
				Mustworkday.deleteById(old.get(i).id);
		}
    }
}
