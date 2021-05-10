package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Day08Application {

	public static void main(String[] args) {
		//BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密"0"
       // String encode = bCryptPasswordEncoder.encode("111111");
        //System.out.println(encode);
		SpringApplication.run(Day08Application.class, args);
	}

}
