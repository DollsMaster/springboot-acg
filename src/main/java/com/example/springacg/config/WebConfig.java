package com.example.springacg.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletResponse;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {
    @Value("${file-save-path}")
    private String fileSavePath;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowedHeaders("*")
                .maxAge(3600);
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + fileSavePath);
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> {
            System.out.println(!SaHolder.getRequest().getMethod().equals(HttpMethod.OPTIONS.toString()));
            if (!SaHolder.getRequest().getMethod().equals(HttpMethod.OPTIONS.toString())) {
                StpUtil.checkLogin();
            }
        })).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginOut")
                .excludePathPatterns("/menu/getMenuList")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }
}