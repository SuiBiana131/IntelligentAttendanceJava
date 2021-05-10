package com.example.demo.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.ai.GsonUtils;
import com.example.demo.controller.HelloController;
import com.example.demo.entity.Airesult;
import com.example.demo.entity.JurUser;
import com.example.demo.entity.User;
import com.example.demo.mapper.JurUserMapper;
import com.example.demo.service.UserMapperService;

@Component
public class AiLoginProvider implements AuthenticationProvider {

	@Autowired
    private UserMapperService userMapperService;
    @Autowired
	JurUserMapper jurUserMapper;
    @Resource
    private AuthenticationManager authenticationManager;
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	logger.info("第三方微信登录");
    	String ailogin = (String) authentication.getCredentials();
    	String accessToken=com.example.demo.ai.acccessKey.getAuth();
		Map<String,String> map= new HashMap<String, String>();map.put("image", ailogin.substring(22));map.put("liveness_control", "NORMAL");
        map.put("group_id_list", "2021_03_lzr");map.put("image_type", "BASE64");map.put("quality_control", "LOW");
    	String param = GsonUtils.toJson(map);
    	String res=com.example.demo.ai.FaceSearch.faceSearch(param, accessToken);
    	Airesult result = GsonUtils.fromJson(res, Airesult.class);
    	if(result==null)
    		return null;
    	//System.out.println(result.getResult().getUser_list().get(0).getUser_id());
    	User user= userMapperService.selectById(result.getResult().getUser_list().get(0).getUser_id());
    	List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    	JurUser ju= jurUserMapper.selectById(user.getId());
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
        return new AiLoginAuthenticationToken(user.getName(), user.getPassword(), grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
    	//第二步拦截封装了WxLoginAuthenticationToken，此处校验，如果是该类型，则在该处理器做登录校验
    	System.out.print(AiLoginAuthenticationToken.class.isAssignableFrom(aClass));
        return AiLoginAuthenticationToken.class.isAssignableFrom(aClass);
    }
}