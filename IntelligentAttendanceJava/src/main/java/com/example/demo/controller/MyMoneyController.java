package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.MyMoney;
import com.example.demo.service.MyMoneyMapperService;

@Controller
@CrossOrigin
@RequestMapping("/MyMoney")
public class MyMoneyController {
	@Autowired
    private MyMoneyMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return "MyMoney";
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
	public MyMoney selectOne() {
		MyMoney de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectCount")
	@ResponseBody
	public Map<String,Long> selectCount() {
		 Map<String,Long> de= service.selectCount(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<MyMoney> selectAll() {
		 List<MyMoney> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectCondition")
	@ResponseBody
	public List<MyMoney> selectCondition(@RequestParam Map<String,Object> map) {
		System.out.println(map.get("userid"));
		System.out.println(map.get("state"));
		//String date= (String) map.get("date");
		//map.put("date", date.subSequence(0, 10));
		System.out.println(map.get("date"));
		System.out.print("dads");
		
		List<MyMoney> de= service.selectCondition(map);
		
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(MyMoney information) {
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
	public void update(MyMoney information) {
		service.update(information);;
		System.out.print("update");
    }
}
