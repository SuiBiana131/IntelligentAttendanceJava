package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Money;
import com.example.demo.service.MoneyMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Money")
public class MoneyController {
	@Autowired
    private MoneyMapperService service;
	@RequestMapping("/show")
    public String getIndex() {
        return " Money";
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
	public Money selectOne() {
		Money de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectMoney")
	@ResponseBody
	public Map selectMoney() {
		Map de= service.selectMoney(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Money information) {
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
	public void update(Money information) {
		service.update(information);;
		System.out.print("update");
    }
}
