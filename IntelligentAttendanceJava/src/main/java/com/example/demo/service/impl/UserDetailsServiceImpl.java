package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.demo.entity.JurUser;
import com.example.demo.entity.User;
import com.example.demo.mapper.JurUserMapper;
import com.example.demo.service.UserMapperService;

/**
 * 自定义的认证用户获取服务类
 */
@Component("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapperService userMapperService;
    @Autowired
	JurUserMapper jurUserMapper;

    /**
     * 根据用户名获取认证用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println(username);
        if(StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("UserDetailsService没有接收到用户账号");
        } else {
            /**
             * 根据用户名查找用户信息
             */
            User authUser = userMapperService.selectByName(username);
            if(authUser == null) {
                throw new UsernameNotFoundException(String.format("用户"+ username+"不存在"));
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                //封装用户信息和角色信息到SecurityContextHolder全局缓存中
            JurUser ju= jurUserMapper.selectById(authUser.getId());
            if(ju.getJurid()==1)
            	{grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SADMIN"));
            	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            	}
            else if(ju.getJurid()==2)
            	{grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            	}
            else if(ju.getJurid()==3)
            	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            else 
            	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_WEI"));
            /**
             * 创建一个用于认证的用户对象并返回，包括：用户名，密码，角色
             */
            return new org.springframework.security.core.userdetails.User(authUser.getName(), authUser.getPassword(), grantedAuthorities);
        }
    }
}
