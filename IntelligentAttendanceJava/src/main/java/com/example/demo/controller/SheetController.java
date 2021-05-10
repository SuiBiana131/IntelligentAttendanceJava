package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("/Sheet")
public class SheetController {
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
	@Autowired
	private SheetMapperService Sheet;
	
	@RequestMapping("/select")
	@ResponseBody
	public Sheet selectOne() {
		Sheet de= Sheet.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Sheet> selectAll() {
		 List<Sheet> de= Sheet.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAllByUse")
	@ResponseBody
	public List<Sheet> selectAllByUse() {
		 List<Sheet> de= Sheet.selectAllByUse();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAllByNotuse")
	@ResponseBody
	public List<Sheet> selectAllByNotuse() {
		 List<Sheet> de= Sheet.selectAllByNotuse();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Sheet information) {
		Sheet.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(int id) {
		Sheet.deleteById(id);
		Design.deleteByOid(id);
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(Sheet information) {
		Sheet.update(information);;
		System.out.print("update");
    }
	@RequestMapping("/selectCondition")
	@ResponseBody
	public void selectCondition(@RequestParam Map<String,Object> map) {
		System.out.println(map.get("cg"));
		System.out.println(map.get("fc"));
		System.out.println(map.get("mp"));
		System.out.println(map.get("md"));
		System.out.println(map.get("nd"));
    }
}

