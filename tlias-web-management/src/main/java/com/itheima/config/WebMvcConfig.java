package com.itheima.config;

import com.itheima.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    /**
     * 注册JWT拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册JWT拦截器，拦截所有请求，但排除登录接口和静态资源
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")     // 拦截所有请求
                .excludePathPatterns(       // 排除以下路径
                        "/login",           // 登录接口
                        "/upload/**",       // 文件上传接口
                        "/error",           // 错误页面
                        "/static/**",       // 静态资源
                        "/*.html",          // HTML页面
                        "/*.js",            // JS文件
                        "/*.css",           // CSS文件
                        "/*.ico",           // 图标文件
                        "/swagger-ui.html", // Swagger接口文档
                        "/webjars/**",      // Swagger相关资源
                        "/swagger-resources/**", // Swagger相关资源
                        "/v2/api-docs"      // Swagger API文档
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:90")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
} 