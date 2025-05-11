package com.itheima.filter;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import javax.servlet.ServletException;
import com.itheima.pojo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;

    //1.获取请求的URI
    String url = req.getRequestURI();
    log.info("拦截到请求: {}", url);

    //2.判断请求是否需要拦截
    if(url.contains("/login")){
      chain.doFilter(request, response);
      return;
    }

    //3.获取请求头中的令牌
    String token = req.getHeader("token");
    log.info("拦截到请求: {},令牌: {}", url, token);

    //4.判断令牌是否存在,如果不存在，返回错误结果
    if(token == null){
      log.info("拦截到请求: {},令牌不存在", url);
      Result result = Result.error("NOT_LOGIN");
      //将Result对象转换为JSON字符串
      String json = new ObjectMapper().writeValueAsString(result);
      resp.getWriter().write(json);
      return;
    }

    //5.解析token，如果解析失败，返回错误结果
    try {
      JwtUtils.parseJWT(token);
    } catch (Exception e) {
      e.printStackTrace();
      log.info("解析令牌失败，返回错误结果");
      Result result = Result.error("NOT_LOGIN");
      String json = new ObjectMapper().writeValueAsString(result);
      resp.getWriter().write(json);
      return;
    }

    //6.放行
    log.info("令牌合法，放行");
    chain.doFilter(request, response);

  }
}
