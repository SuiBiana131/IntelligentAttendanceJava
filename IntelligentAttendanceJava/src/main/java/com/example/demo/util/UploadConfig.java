package com.example.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址E:\作业区\综合课程设计\headShow
        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:\\作业区\\综合课程设计\\headShow\\");
      //映射图片保存地址E:\作业区\综合课程设计\aiLogin
        registry.addResourceHandler("/aiLogin/**").addResourceLocations("file:E:\\作业区\\综合课程设计\\aiLogin\\");
    }
}
