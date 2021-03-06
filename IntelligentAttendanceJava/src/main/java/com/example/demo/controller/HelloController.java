package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ai.Base64Util;
import com.example.demo.ai.FileUtil;
import com.example.demo.ai.GsonUtils;
import com.example.demo.entity.Department;
import com.example.demo.entity.Information;
import com.example.demo.entity.MyMoney;
import com.example.demo.service.DepartmentMapperService;
import com.example.demo.service.InformationMapperService;

@Controller
@CrossOrigin
@RequestMapping("/Information")
public class HelloController {
	
	@Autowired
    private InformationMapperService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/show")
	@ResponseBody
    public String getIndex(String image) throws IOException {
		System.out.println(image.substring(22, 50));
		String accessToken=com.example.demo.ai.acccessKey.getAuth();
		Map<String,String> map= new HashMap<String, String>();
		map.put("image", image.substring(22));
        map.put("group_id", "2021_03_lzr");
        map.put("user_id", "3");
        map.put("image_type", "BASE64");
    	String param = GsonUtils.toJson(map);
    	//System.out.println(param);
    	String res=com.example.demo.ai.FaceAdd.faceAdd(param, accessToken);
    	return res;
    }
	@RequestMapping("/FaceSearch")
	@ResponseBody
    public String FaceSearch(String image) throws IOException {
		System.out.println(image.substring(22, 50));
		String accessToken=com.example.demo.ai.acccessKey.getAuth();
		Map<String,String> map= new HashMap<String, String>();
		map.put("image", image.substring(22));
        map.put("liveness_control", "NORMAL");
        map.put("group_id_list", "2021_03_lzr");
        map.put("image_type", "BASE64");
        map.put("quality_control", "LOW");
    	String param = GsonUtils.toJson(map);
    	//System.out.println(param);
    	String res=com.example.demo.ai.FaceSearch.faceSearch(param, accessToken);
    	return res;
    }
	/**@RequestMapping("/select")
	@ResponseBody
	public String selectOne() {
		Department de= service.selectOne(2);
		System.out.print(de.getDepartmentName());
        return "hello";
    }**/
	@RequestMapping("/upload")//?????????????????????
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "??????????????????????????????";
        }
        String fileName = file.getOriginalFilename();
        //??????????????????
        String filePath = "E:\\?????????\\??????????????????\\headShow\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("????????????");
            return "????????????";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "???????????????";
    }
	@RequestMapping("/aiLoginShow")//??????????????????????????????????????????????????????(????????????)
    @ResponseBody
    public String aiLoginShow(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "??????????????????????????????";
        }
        String fileName = file.getOriginalFilename();
        //??????????????????
        String filePath = "E:\\?????????\\??????????????????\\aiLogin\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("????????????");
            return "????????????";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "???????????????";
    }
	@RequestMapping("/photograph")//??????????????????????????????????????????????????????(????????????)
    @ResponseBody
    public String photograph(@RequestParam String imageUrl,@RequestParam String name) {
		System.out.println(imageUrl.substring(0,22));System.out.println(name);
		Base64Util.base64ToFile(imageUrl.substring(22), name);
        return "???????????????";
    }
	@RequestMapping("/aiAdd")
	@ResponseBody
	public String aiAdd(String str) throws IOException {
		String image=Base64Util.encode(FileUtil.readFileByBytes("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\lzr.jpg"));
		String accessToken=com.example.demo.ai.acccessKey.getAuth();
		Map<String,String> map= new HashMap<String, String>();
		map.put("image", image);
        map.put("group_id", "2021_03_lzr");
        map.put("user_id", "1");
        map.put("image_type", "BASE64");
    	String param = GsonUtils.toJson(map);
    	//System.out.println(param);
    	String res=com.example.demo.ai.FaceAdd.faceAdd(param, accessToken);
    	return res;
    }
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/select")
	@ResponseBody
	public Information selectOne(int id) {
		Information de= service.selectById(id);
		System.out.print(de.getAddress());
        return service.selectById(id);
    }
	@RequestMapping("/selectName")
	@ResponseBody
	public Information selectName(String username) {
		Information de= service.selectName(username);
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Information> selectAll() {
		 List<Information> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectCondition")
	@ResponseBody
	public List<Information> selectCondition(@RequestParam Map<String,Object> map) {
		System.out.println(map.get("nickname"));
		
		List<Information> de= service.selectCondition(map);
		
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(Information information) {
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
	public void update(Information information) {
		System.out.print(information.toString());;
		service.update(information);;
		System.out.print("update");
    }
}
