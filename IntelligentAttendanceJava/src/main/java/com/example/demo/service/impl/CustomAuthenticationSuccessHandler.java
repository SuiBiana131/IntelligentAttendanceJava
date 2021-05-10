package com.example.demo.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
    private ObjectMapper objectMapper;
	
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //logger.info("登录成功,{}", authentication);
        //System.out.println(authentication.toString());
        //response.sendRedirect("/");
        //登录成功后获取当前登录用户
        logger.info("用户[{}]于[{}]登录成功!", authentication.getName(), new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","登录成功");
        map.put("username",authentication.getName());
        map.put("role",authentication.getAuthorities());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(map));

    }
}