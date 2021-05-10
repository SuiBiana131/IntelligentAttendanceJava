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
@RequestMapping("/Design")
public class DesignController {
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
	public Design selectOne() {
		Design de= Design.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectByOid")
	@ResponseBody
	public List<Design> selectByOid(@RequestParam int oaId) {
		 List<Design> de= Design.selectByOid(oaId);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Design> selectAll() {
		 List<Design> de= Design.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Design information) {
		Design.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		Design.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestBody List<Design> Designs) {
		Map<Integer,Design> map= new HashMap<>();
		List<Design> old= Design.selectByOid(Designs.get(0).getOaId());
		for(int i=0;i<Designs.size();i++) {
			if(Designs.get(i).id<0)
				Design.insert(Designs.get(i));
			else
				map.put(Designs.get(i).id, Designs.get(i));
		}
		for(int i=0;i<old.size();i++) {
			if(map.containsKey(old.get(i).id))
				Design.update(map.get(old.get(i).id));
			else
				Design.deleteById(old.get(i).id);
		}
		System.out.print("update");
    }
}
