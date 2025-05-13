package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperationLogMapper;
import com.itheima.pojo.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import jakarta.servlet.http.HttpServletRequest; // Spring Boot 3.x
import javax.servlet.http.HttpServletRequest; // Spring Boot 2.x
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private OperationLogMapper operationLogMapper;

    // 更新@Around通知以使用@RecordOperationLog注解
    @Around("@annotation(com.itheima.anno.RecordOperationLog)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作开始时间
        long begin = System.currentTimeMillis();

        // 执行原始方法
        Object result = joinPoint.proceed();

        // 操作结束时间
        long end = System.currentTimeMillis();

        // 构造操作日志记录对象
        OperationLog logEntry = new OperationLog();

        // 设置操作时间
        logEntry.setOperateTime(LocalDateTime.now());

        // 设置操作类名
        String className = joinPoint.getTarget().getClass().getName();
        logEntry.setClassName(className);

        // 设置操作方法名
        String methodName = joinPoint.getSignature().getName();
        logEntry.setMethodName(methodName);

        // 设置方法参数 (转换为JSON字符串)
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        try {
            methodParams = JSONObject.toJSONString(args);
        } catch (Exception e) {
            log.error("Error converting args to JSON: {}", e.getMessage());
            // 保留 Arrays.toString 作为后备
        }
        logEntry.setMethodParams(methodParams);

        // 设置返回值 (转换为JSON字符串)
        String returnValue = "void";
        if (result != null) {
            try {
                returnValue = JSONObject.toJSONString(result);
            } catch (Exception e) {
                log.error("Error converting return value to JSON: {}", e.getMessage());
                returnValue = result.toString(); // 后备
            }
        }
        logEntry.setReturnValue(returnValue);

        // 设置方法执行耗时
        logEntry.setCostTime(end - begin);

        // 设置操作人ID - 从JWT令牌中获取用户信息
        Integer userIdFromToken = null; // 初始化为null
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 获取请求头中的JWT令牌
            String jwt = request.getHeader("token");
            if (jwt != null && !jwt.isEmpty()) {
                try {
                    // 解析JWT令牌 (确保签名密钥 "itheima" 与生成令牌时一致)
                    Claims claims = Jwts.parser()
                            .setSigningKey("itheima")
                            .parseClaimsJws(jwt)
                            .getBody();

                    // 获取用户ID
                    userIdFromToken = claims.get("id", Integer.class);
                } catch (Exception e) {
                    log.error("JWT解析失败或获取用户ID失败: {}", e.getMessage());
                    // userIdFromToken 保持为 null
                }
            }
        }
        logEntry.setOperateUser(userIdFromToken); // 设置从JWT获取到的用户ID，如果失败则为null

        // 插入日志记录到数据库
        operationLogMapper.insert(logEntry);
        log.info("AOP记录操作日志: {}", logEntry);

        return result;  
    }
} 