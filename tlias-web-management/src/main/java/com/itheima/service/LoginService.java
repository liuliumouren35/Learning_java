package com.itheima.service;

import com.itheima.pojo.LoginRequest;
import com.itheima.pojo.LoginResponse;

public interface LoginService {
  LoginResponse login(LoginRequest loginRequest);
}
