package com.example.demo.service.impl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("customAuthenticationFailureHandler")
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登陆失败");

       /// response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
       //response.setContentType("application/json;charset=UTF-8");
       // response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
        System.out.println(HttpServletResponse.SC_UNAUTHORIZED);
        Map<String, String> map = new HashMap<>();
        map.put("code","2");
        map.put("msg","登录失败！未知错误！");
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
        	map.put("code", "3");
        	map.put("msg","登录失败！用户名或密码错误!");
        } else if (exception instanceof DisabledException) {
        	map.put("code", "4");
        	map.put("msg","登录失败！用户无权限!");
        } 
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(map));

    }
}
