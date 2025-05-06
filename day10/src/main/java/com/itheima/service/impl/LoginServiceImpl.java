package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginRequest;
import com.itheima.pojo.LoginResponse;
import com.itheima.service.LoginService;
import com.itheima.utils.JWTutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录服务实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private JWTutils jwtUtils;

    /**
     * 员工登录
     *
     * @param loginRequest 登录请求
     * @return 登录响应，包含JWT令牌
     */
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // 1. 根据用户名查询员工
        Emp emp = empMapper.getByUsername(loginRequest.getUsername());
        
        // 2. 判断员工是否存在
        if (emp == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        
        // 3. 密码比对
        // 注意：实际系统中应该对密码进行加密存储和比对，这里为了简化使用明文比对
        // 如果需要MD5加密比对，可以使用下面代码
        // String md5Password = DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes());
        if (!loginRequest.getPassword().equals(emp.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        
        // 4. 生成JWT令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", emp.getId());
        claims.put("username", emp.getUsername());
        claims.put("name", emp.getName());
        
        String token = jwtUtils.generateToken(claims);
        
        // 5. 封装并返回结果
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(emp.getId());
        loginResponse.setUsername(emp.getUsername());
        loginResponse.setName(emp.getName());
        loginResponse.setToken(token);
        
        return loginResponse;
    }
}
