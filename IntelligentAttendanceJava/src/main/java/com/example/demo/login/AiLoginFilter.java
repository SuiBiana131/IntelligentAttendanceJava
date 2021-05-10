package com.example.demo.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

public class AiLoginFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    public static final String SPRING_SECURITY_FORM_AILOGIN_KEY = "ailogin";
    private String usernameParameter = "username";
    private String passwordParameter = "password";
    private String ailoginParameter = "ailogin";
    private boolean postOnly = true;

    public AiLoginFilter() {
        super(new AntPathRequestMatcher("/aiLogin", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = obtainUsername(request);
            String password = obtainPassword(request);
            String ailogin = obtainAilogin(request);
            if (username == null) {
                username = "";
            }

            if (password == null) {
                password = "";
            }

            if (ailogin == null) {
            	ailogin = "";
            }
            username = username.trim();

            // 该处对第一步的token进行包装，用于在AuthenticationProvider里面校验是否该AuthenticationProvider拦截校验
            AiLoginAuthenticationToken authRequest = new AiLoginAuthenticationToken(username, ailogin);
            System.out.println(username);
            System.out.println(password);
            System.out.println(ailogin);
            
            setDetails(request, authRequest);
            Authentication authentication=this.getAuthenticationManager().authenticate(authRequest);
            return authentication;
        }
    }

    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(this.passwordParameter);
    }

    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    protected String obtainAilogin(HttpServletRequest request) {
        return request.getParameter(this.ailoginParameter);
    }
    
    protected void setDetails(HttpServletRequest request, AiLoginAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }
    
    public void setAiloginParameter(String ailoginParameter) {
        Assert.hasText(ailoginParameter, "ailoginParameter parameter must not be empty or null");
        this.ailoginParameter = ailoginParameter;
    }
    
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getUsernameParameter() {
        return this.usernameParameter;
    }

    public final String getPasswordParameter() {
        return this.passwordParameter;
    }
    
    public final String getailoginParameter() {
        return this.ailoginParameter;
    }
}
