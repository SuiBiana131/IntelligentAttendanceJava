package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Information;
import com.example.demo.entity.JurUser;
import com.example.demo.entity.Oadesigner;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccommodation;
import com.example.demo.service.InformationMapperService;
import com.example.demo.service.JurUserMapperService;
import com.example.demo.service.UserAccommodationMapperService;
import com.example.demo.service.UserMapperService;

@CrossOrigin
@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
    private UserMapperService service;
	@Autowired
    private JurUserMapperService jurservice;
	@Autowired
    private InformationMapperService inservice;
	@Autowired
    private UserAccommodationMapperService uaservice;
	@Autowired
    private UserDetailsService detailservice;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@RequestMapping("/show")
    public String getIndex() {
        return "User";
    }
	
	/**@RequestMapping("/select")
	@ResponseBody
	public String selectOne() {
		Department de= service.selectOne(2);
		System.out.print(de.getDepartmentName());
        return "hello";
    }**/
	@RequestMapping("/login")
	@ResponseBody
	public int login(User user) {
		//System.out.println(user.getName());
		User list= service.selectByName(user.getName());
		if(list==null)
			return -1;
		//System.out.println(list.size());
		//System.out.println(list.get(0).getName());
		if(list.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes())))
			{
			UserDetails ud=detailservice.loadUserByUsername(user.getName());
			System.out.print(ud.toString());
			return list.getId();}
		//System.out.print(de.getAddress());
        return -2;
    }
	@RequestMapping("/resgin")
	@ResponseBody
	public String resgin(User user) {
		User list= service.selectByName(user.getName());
		if(list!=null)
			return "注册失败！账号名称以存在！";
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Password);
		service.insert(user);
		User users= service.selectByName(user.getName());
		JurUser ju=new JurUser();
		ju.setUserid(users.getId());ju.setJurid(3);
		Information in=new Information();
		in.setUserid(users.getId());
		UserAccommodation ua=new UserAccommodation();
		ua.setAccommodationid(1);ua.setUserid(users.getId());
		jurservice.insert(ju);
		inservice.insert(in);
		uaservice.insert(ua);
		System.out.print(md5Password);
		return "注册成功！";
    }
	@GetMapping("/select")
	@ResponseBody
	public User selectOne(int id) {
		User de= service.selectById(id);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(User information) {
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
	public String update(@RequestParam Map<String,String> map) {
		
		int id=Integer.parseInt(map.get("id"));
		String oldPassword=map.get("oldPassword");
		User olduser=service.selectById(id);
		System.out.print(bCryptPasswordEncoder.encode(map.get("newPassword")));
		if(!bCryptPasswordEncoder.matches(oldPassword, olduser.getPassword()))
			return "修改失败，旧密码错误！";
		User user=new User();
		user.setId(id);
		user.setPassword(bCryptPasswordEncoder.encode(map.get("newPassword")));
		service.update(user);;
		System.out.print("update");
		return "修改成功！"+oldPassword+user.getPassword();
    }
	@RequestMapping("/test")
	@ResponseBody
	public List<Oadesigner> test() {
		List<Oadesigner> de=service.test(1);;
		System.out.print("成功！");
		return de;
    }
}
