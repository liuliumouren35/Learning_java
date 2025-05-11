package com.itheima.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import com.itheima.utils.JwtUtils;
import com.itheima.pojo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.FilterChain;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

  @Override//在请求处理之前进行拦截,如果返回true,则继续执行请求,如果返回false,则拦截请求
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
      throws Exception {
        //1.获取请求的URI
        String url = req.getRequestURI();
        log.info("拦截到请求: {}", url);
    
        //2.判断请求是否需要拦截
        if(url.contains("/login")){
          log.info("请求: {} 不需要拦截，放行", url);
          return true;
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
          return false;
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
          return false;
        }
    
        //6.放行
        log.info("令牌合法，放行");
        return true;
  }

  @Override//在请求处理之后进行拦截,在视图渲染之前进行拦截
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("视图渲染之前");
  }

  @Override//在视图渲染之后进行拦截,在请求处理之后进行拦截
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      Exception ex) throws Exception {
    System.out.println("请求处理之后");
  }
}
