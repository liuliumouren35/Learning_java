package com.itheima.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Integer id;
    private String username;
    private String name;
    private String token;
}