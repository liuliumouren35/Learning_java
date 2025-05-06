package com.itheima.controller;

import com.itheima.pojo.LoginRequest;
import com.itheima.pojo.LoginResponse;
import com.itheima.pojo.Result;
import com.itheima.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口控制器
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
  
  @Autowired
  private LoginService loginService;
  
  /**
   * 员工登录
   * 
   * @param loginRequest 登录请求
   * @return 登录结果，包含JWT令牌
   */
  @PostMapping
  public Result login(@RequestBody LoginRequest loginRequest) {
    log.info("员工登录: {}", loginRequest.getUsername());
    
    // 调用登录服务
    LoginResponse loginResponse = loginService.login(loginRequest);
    
    // 返回登录结果
    return Result.success(loginResponse);
  }
}
