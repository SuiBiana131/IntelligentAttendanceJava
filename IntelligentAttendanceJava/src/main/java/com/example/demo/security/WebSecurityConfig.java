package com.example.demo.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.cors.CorsUtils;

import com.example.demo.login.AiLoginAuthenticationToken;
import com.example.demo.login.AiLoginFilter;
import com.example.demo.login.AiLoginProvider;
import com.example.demo.service.UserMapperService;
import com.example.demo.service.impl.CustomAuthenticationFailureHandler;
import com.example.demo.service.impl.CustomAuthenticationSuccessHandler;
import com.example.demo.service.impl.MyAccessDeniedHandler;
import com.example.filter.VerifyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsServiceImpl;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
	@Autowired
	private AiLoginProvider aiLoginProvider;
	
    /**
     * 用户认证配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 指定用户认证时，默认从哪里获取认证用户信息
         */
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    	auth.authenticationProvider(aiLoginProvider);
    }

    /**
     * Http安全配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**第一种写法，未登录等一系列情况不会返回josn串。
         * 表单登录：使用默认的表单登录页面和登录端点/login进行登录
         * 退出登录：使用默认的退出登录端点/logout退出登录
         * 记住我：使用默认的“记住我”功能，把记住用户已登录的Token保存在内存里，记住30分钟
         * 权限：除了/toHome和/toUser之外的其它请求都要求用户已登录
         * 注意：Controller中也对URL配置了权限，如果WebSecurityConfig中和Controller中都对某文化URL配置了权限，则取较小的权限,"/User/**","/**"
         */
    	http.addFilterBefore(aiLoginFilter(), AbstractPreAuthenticatedProcessingFilter.class);
        http
            .formLogin()
            	//loginProcessingUrl中的url代表表单中action的值
            	.loginProcessingUrl("/userlogin").permitAll()
            	//这里指定的是表单中name="username"的参数作为登录用户名，name="password"的参数作为登录密码
            	.usernameParameter("username").passwordParameter("password")
            	.successHandler(customAuthenticationSuccessHandler)
            	.failureHandler(customAuthenticationFailureHandler)
//                .defaultSuccessUrl("/")
                .permitAll()
//                .failureUrl("/loginError")
                .and()
                .addFilterBefore(new VerifyFilter(),UsernamePasswordAuthenticationFilter.class)
            .logout()
                .permitAll()
                .and()
            .rememberMe()
                .tokenValiditySeconds(1800)
                .and()
            .authorizeRequests()
            	.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/toHome", "/toUser","/User/test","/test","/aiLogin","/execl","/Information/FaceSearch","/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().cors()
                .and()
                .csrf().disable();
        
    }
    
  //这个必须重写，才能使用AuthenticationManager，在成员变量注入进来，再注入过滤器中
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public AiLoginFilter aiLoginFilter() {
    	AiLoginFilter filter = new AiLoginFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
        filter.setFilterProcessesUrl("/aiLogin");
        return filter;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new MyAccessDeniedHandler();
    }
    /*/
    @Override
    public void configure(WebSecurity web) {
        //对于在header里面增加token等类似情况，放行所有OPTIONS请求。
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //对默认的UserDetailsService进行覆盖
        
        return authenticationProvider;
    }
    */
}
