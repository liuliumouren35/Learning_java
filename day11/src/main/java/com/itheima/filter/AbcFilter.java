package com.itheima.filter;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.FilterChain;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("ABC拦截到请求: {},放行前的逻辑", request.getRemoteAddr());
        chain.doFilter(request, response);//放行,放到下一个过滤器
        log.info("ABC拦截到请求: {},放行后的逻辑", request.getRemoteAddr());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("初始化过滤器");
    }

    @Override
    public void destroy() {
      log.info("销毁过滤器");
    }
}
