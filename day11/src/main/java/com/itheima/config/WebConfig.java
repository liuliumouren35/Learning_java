package com.itheima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.itheima.intercepter.LoginCheckInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired//注入拦截器
  private LoginCheckInterceptor loginCheckInterceptor;
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //添加拦截器,拦截所有请求,排除登录请求
    registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
  }
}
