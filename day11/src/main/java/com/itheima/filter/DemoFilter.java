package com.itheima.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")//拦截所有请求
public class DemoFilter implements Filter {

    @Override//拦截到请求后，会执行这个方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        log.info("Demo拦截到请求: {},放行前的逻辑", request.getRemoteAddr());
        chain.doFilter(request, response);//放行
        log.info("Demo拦截到请求: {},放行后的逻辑", request.getRemoteAddr());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("初始化过滤器");
    }

    @Override//销毁
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("销毁过滤器");
    }
    
    

}