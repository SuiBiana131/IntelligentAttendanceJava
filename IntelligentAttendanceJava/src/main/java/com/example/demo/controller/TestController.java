package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.ai.GsonUtils;
import com.example.demo.entity.User;
import com.example.demo.service.UserMapperService;
import com.example.demo.ai.FileUtil;
import com.example.demo.ai.Base64Util;

@Controller
public class TestController {
	
	@Autowired
    private UserMapperService service;
	
	@RequestMapping("/")
    @ResponseBody
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return name;
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
    
    @RequestMapping("/loginError")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String image1=Base64Util.encode(FileUtil.readFileByBytes("D:/JAVA/Maven/day08/src/main/java/com/example/demo/image/test1.jpg"));
    	String image2=Base64Util.encode(FileUtil.readFileByBytes("D:/JAVA/Maven/day08/src/main/java/com/example/demo/image/test3.jpg"));
    	String accessToken=com.example.demo.ai.acccessKey.getAuth();
    	System.out.println(accessToken);
    	System.out.println("das");
    	List<Map<String,String>> maps= new java.util.ArrayList<>();
    	Map<String,String> map1= new HashMap<String, String>();
    	map1.put("image", image1);
    	map1.put("image_type",  "BASE64");
    	map1.put("face_type",  "LIVE");
    	map1.put("quality_control",  "LOW");
    	map1.put("liveness_control",  "NONE");
    	Map<String,String> map2= new HashMap<String, String>();
    	map2.put("image",  image2);
    	map2.put("image_type",  "BASE64");
    	map2.put("face_type",  "IDCARD");
    	map2.put("quality_control",  "LOW");
    	map2.put("liveness_control",  "NONE");
    	maps.add(map1);
    	maps.add(map2);
    	String param = GsonUtils.toJson(maps);
    	//System.out.println(param);
    	String res=com.example.demo.ai.FaceMatch.faceMatch(param, accessToken);
    	//System.out.print(res);
    }
    @RequestMapping("/execl")
    public void downloadFile(HttpServletResponse response) {
    	// 调用接口查询指定数据库表所有的记录
        List<User> all = service.selectAll();
        ExportExcel<User> sysLogExportExcel = new ExportExcel<>();
        String[] headers ={"id","name","password"};
        String fileName = "操作日志";
        sysLogExportExcel.exportExcel(headers,all,fileName,response);

    }
}
