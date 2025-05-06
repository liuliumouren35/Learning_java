package com.itheima.interceptor;

import com.itheima.utils.JWTutils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT拦截器，验证Token
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTutils jwtUtils;

    /**
     * 前置拦截器，验证JWT令牌
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取请求头中的token
        String token = request.getHeader("Authorization");
        
        // 2. 检查token是否存在
        if (!StringUtils.hasLength(token)) {
            response.setStatus(401); // 未授权
            return false;
        }
        
        // 3. 如果token格式为"Bearer xxx"，则提取实际token部分
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        // 4. 验证token
        if (!jwtUtils.validateToken(token)) {
            response.setStatus(401); // 未授权
            return false;
        }
        
        // 5. 解析token，获取用户信息
        Claims claims = jwtUtils.parseToken(token);
        
        // 6. 将用户信息存储到请求属性中，方便后续使用
        request.setAttribute("user_id", claims.get("id"));
        request.setAttribute("username", claims.get("username"));
        
        // 7. 放行请求
        return true;
    }
} 